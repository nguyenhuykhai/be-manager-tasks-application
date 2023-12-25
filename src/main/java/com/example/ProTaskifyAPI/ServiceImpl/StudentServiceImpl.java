package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.DTO.Response.ListStudentResponse;
import com.example.ProTaskifyAPI.DTO.Response.TotalTasksResponse;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.UpdateLinkRequest;
import com.example.ProTaskifyAPI.Models.Group;
import com.example.ProTaskifyAPI.Models.Student;
import com.example.ProTaskifyAPI.Models.StudentTask;
import com.example.ProTaskifyAPI.Models.StudentTaskCompositeKey;
import com.example.ProTaskifyAPI.Repositories.GroupRepo;
import com.example.ProTaskifyAPI.Repositories.StudentRepo;
import com.example.ProTaskifyAPI.Repositories.StudentTaskRepo;
import com.example.ProTaskifyAPI.Repositories.TaskRepo;
import com.example.ProTaskifyAPI.Services.StudentService;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
  final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
  private final StudentRepo studentRepo;
  private final GroupRepo groupRepo;
  private final StudentTaskRepo studentTaskRepo;
  private final JwtService jwtService;
  private final TaskRepo taskRepo;
  private List<ListStudentResponse> studentList;

  @Override
  public boolean checkIfStudentInClass(int studentID) {
    Student s = studentRepo.findById(studentID).orElse(null);

    return s != null && s.getClassID() != null;
  }

  @Override
  public void setLeader(int studentID) {
    Student s = studentRepo.findById(studentID).orElse(null);
    if (s != null) {
      s.set_leader(true);
      studentRepo.save(s);
    }
  }

  @Override
  public ResponseEntity<ResponseObject> getAll() {
    try {
      studentList = studentRepo.getAll();
      logger.info("Return list of user");
      return ResponseEntity.ok(new ResponseObject("Successful", "Found student", studentList));
    } catch (Exception e) {
      studentList = Collections.emptyList();
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(new ResponseObject("Failed", "Not found student", studentList));
    }
  }

  @Override
  public ResponseEntity<ResponseObject> inviteGroup(int groupID, int studentID) {
    Group group = groupRepo.findById(groupID).orElse(null);
    Student student = studentRepo.findById(studentID).orElse(null);
    if (group == null || student == null) {
      return ResponseEntity.ok(new ResponseObject("Failed", "Not found student or group", null));
    }
    try {
      byte[] serializeData = student.getPending();
      if (serializeData == null) {
        ArrayList<Integer> classRoom = new ArrayList<>();
        classRoom.add(groupID); // Thêm học sinh vô group

        serializeData = writeArrayToByteArray(classRoom); // mã hóa class room
        student.setPending(serializeData); // thay đổi giá trị của pending
        return ResponseEntity.ok(
            new ResponseObject(
                "Successful",
                "Invite student to group successful",
                readByteToArray(student.getPending()),
                studentRepo.save(student))); // update student đó
      }
      List<Integer> classRoom = readByteToArray(serializeData);
      classRoom.add(groupID);

      serializeData = writeArrayToByteArray(classRoom);
      student.setPending(serializeData);
      return ResponseEntity.ok(
          new ResponseObject(
              "Successful",
              "Invite student to group successful",
              readByteToArray(student.getPending()),
              studentRepo.save(student)));

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(new ResponseObject("Failed", "Not found student", e.getMessage()));
    }
  }

  @Override
  public ResponseEntity<ResponseObject> acceptInvitation(Integer groupID, Integer studentID) {
    Group group = groupRepo.findById(groupID).orElse(null);
    Student student = studentRepo.findById(studentID).orElse(null);
    if (group == null || student == null) {
      return ResponseEntity.ok(new ResponseObject("Failed", "Not found student or group", null));
    }
    try {
      byte[] serializeData = student.getPending();
      List<Integer> invites = readByteToArray(serializeData);
      if (invites.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ResponseObject("Failed", "No invitation", null)); // update student đó
      }
      if (student.getGroupID() != null) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ResponseObject("Failed", "Student already in group", null));
      }

      if (invites.contains(groupID)) {
        student.setGroupID(group);
        invites.clear();
        student.setPending(writeArrayToByteArray(invites));

        return ResponseEntity.ok(
            new ResponseObject(
                "Successful", "Student join to group successful", studentRepo.save(student)));
      } else {
        return ResponseEntity.ok(
            new ResponseObject("Failed", "No invitation was found", invites, null));
      }

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(new ResponseObject("Failed", "Not found student", e.getMessage()));
    }
  }

  @Override
  public ResponseEntity<ResponseObject> getTotalTasksStatus(Integer projectID) {
    try {
      String token =
          ((ServletRequestAttributes)
                  Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
              .getRequest()
              .getHeader("Authorization")
              .substring(7);
      String userEmail = jwtService.extractEmail(token);
      var requester = studentRepo.findByEmail(userEmail).orElse(null);
      if (requester == null) {
        throw new Exception("There are no student");
      }
      Integer total_tasks =
          studentTaskRepo.countStudentTaskInProject(
              "Pending", requester.getStudent_id(), projectID);
      Integer total_finished_tasks =
          studentTaskRepo.countStudentTaskInProject(
              "Finished", requester.getStudent_id(), projectID);
      Integer total_late_tasks =
          studentTaskRepo.countStudentTaskInProject(
              "Miss Deadline", requester.getStudent_id(), projectID);

      TotalTasksResponse totalTasksResponse =
          TotalTasksResponse.builder()
              .total_finished_tasks(total_finished_tasks)
              .total_tasks(total_tasks)
              .total_late_tasks(total_late_tasks)
              .build();
      return ResponseEntity.ok(new ResponseObject("Successful", "", totalTasksResponse));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(new ResponseObject("Failed", "Not found student", e.getMessage()));
    }
  }

  @Override
  public ResponseEntity<ResponseObject> demandTask(Integer taskId, Integer studentId) {
    try {
      var task = taskRepo.findById(taskId).orElse(null);
      var student = studentRepo.findById(studentId).orElse(null);
      StudentTask studentTask = StudentTask.builder()
              .id(StudentTaskCompositeKey.builder()
                      .student(studentId)
                      .task(taskId)
                      .build())
              .student(student)
              .task(task)
              .build();
      return ResponseEntity.ok(new ResponseObject("Successful", "Student Task Created", studentTaskRepo.save(studentTask)));
    } catch (Exception e) {
      return ResponseEntity.ok(new ResponseObject("Failed", "Failed to create student task ( check taskId, studentId )", null));
    }
  }

  @Override
  public ResponseEntity<ResponseObject> updateLink(UpdateLinkRequest obj) {
    Student student = studentRepo.findById(obj.getStudent_id()).orElse(null);
    if (student != null) {
      if (isValidLinkFacebook(obj.getLink_facebook())) {
        student.setLink_facebook(obj.getLink_facebook());
      }
      if (isValidLinkGitHub(obj.getGithub())) {
        student.setGithub(obj.getGithub());
      }
      if (isValidLinkEmail(obj.getEmail())) {
        student.setEmail(obj.getEmail());
      }
      return ResponseEntity.ok(
          new ResponseObject("Successful", "The link has been updated", studentRepo.save(student)));
    }

    return ResponseEntity.ok(
        new ResponseObject("Failed", "The link hasn't been updated due to wrong format", student));
  }

  public boolean isValidLinkFacebook(String url) {
    try {
      URL facebook = new URL(url);
      if (!url.isEmpty() && facebook.toString().contains("facebook.com")) {
        HttpURLConnection connection = (HttpURLConnection) facebook.openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        return (responseCode >= 200 && responseCode < 300);
      } else {
        throw new IOException("Incorrect url format");
      }

    } catch (IOException e) {

      return false;
    }
  }

  public boolean isValidLinkGitHub(String url) {
    try {
      URL gitHub = new URL(url);
      if (!url.isEmpty() && gitHub.toString().contains("github.com")) {
        HttpURLConnection connection = (HttpURLConnection) gitHub.openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        return (responseCode >= 200 && responseCode < 300);
      } else {
        throw new IOException("Incorrect url format");
      }

    } catch (IOException e) {

      return false;
    }
  }

  public boolean isValidLinkEmail(String email) {
    return email.contains("@gmail.com");
  }

  public byte[] writeArrayToByteArray(List<Integer> pendingList) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);

    oos.writeObject(pendingList); // This help write the specific object into an output stream
    byte[] serializeData = baos.toByteArray();
    oos.close();

    return serializeData;
  }

  public List<Integer> readByteToArray(byte[] serializeData)
      throws ClassNotFoundException, IOException {
    if (serializeData == null) {
      return Collections.emptyList();
    }
    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serializeData));
    ArrayList<Integer> deserializeArray = (ArrayList<Integer>) ois.readObject();
    ois.close();

    return deserializeArray;
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    ArrayList<String> namesList = new ArrayList<>();

    namesList.add("Geeks");
    namesList.add("for");
    namesList.add("Geeks");

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);

    oos.writeObject(namesList); // This help write the specific object into an output stream
    byte[] serializeData = baos.toByteArray();
    System.out.println("serialize data before " + serializeData.length);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serializeData));
    ArrayList<String> deserializeArray = (ArrayList<String>) ois.readObject();
    ois.close();

    //        for(String item : deserializeArray) {
    //            System.out.println("Item value " + item);
    //        }

  }
}
