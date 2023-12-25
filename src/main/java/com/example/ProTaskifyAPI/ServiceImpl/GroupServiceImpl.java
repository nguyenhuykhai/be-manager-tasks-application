package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.DTO.GroupDTO;
import com.example.ProTaskifyAPI.DTO.Response.GroupProjectDetailsDTO;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.CreateGroupRequest;
import com.example.ProTaskifyAPI.Models.Group;
import com.example.ProTaskifyAPI.Repositories.*;
import com.example.ProTaskifyAPI.Services.GroupService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
  private final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);

  private final GroupRepo groupRepo;

  private final ClassRepo classRepo;

  private final ProjectRepo projectRepo;

  private final ProcessRepo processRepo;

  private final JwtService jwtService;
  
  private final StudentRepo studentRepo;
  @Override
  public ResponseEntity<ResponseObject> createGroup(CreateGroupRequest g) {
    if (false) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body(new ResponseObject("Failed", "Group is already existed", null));
    } else {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new ResponseObject("Successful", "Group successfully be created", addGroup(g)));
    }
  }

  @Override
  public ResponseEntity<ResponseObject> findGroupDetails(
          Integer group_id, Integer class_id) {
    try {
      //Initialize variables
      var group = groupRepo.findGroupProjectDetails(group_id, class_id).orElse(null);
      var project = projectRepo.findGroupProjectDetails(group_id, class_id).orElse(null);
      var student = studentRepo.findGroupProjectDetails(group_id, class_id);
      //Build custom response
      GroupProjectDetailsDTO groupProjectDetailsDTO =
              GroupProjectDetailsDTO.builder()
                      .group_id(group.getGroup_id())
                      .classID(group.getClassID())
                      .groupStudents(group.getGroupStudents())
                      .projectID(project)
                      .groupStudents(student)
                      .group_name(group.getGroup_name())
                      .score(group.getScore())
                      .build();
      logger.info("Return group details");
      return ResponseEntity.ok(
              new ResponseObject("Successful", "Found group", groupProjectDetailsDTO));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body(new ResponseObject("Failed", "No found group", null));
    }
  }

  @Override
  public ResponseEntity<ResponseObject> findStudentsTasks(int group_id, int class_id) {
    try {
      //Initialize variables
      var student = studentRepo.findGroupProjectDetails(group_id, class_id);
      logger.info("Return group students tasks");
      return ResponseEntity.ok(
              new ResponseObject("Successful", "Found group", student));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body(new ResponseObject("Failed", "No found group", null));
    }
  }

  @Override
  public ResponseEntity<ResponseObject> findStudentTask(int group_id, int class_id) {
    try {
      //Initialize variables
      String token =
              ((ServletRequestAttributes)
                      Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                      .getRequest()
                      .getHeader("Authorization")
                      .substring(7);
      String email = jwtService.extractEmail(token);
      var student = studentRepo.findIndividualStudent(group_id, class_id, email);
      logger.info("Return group students tasks");
      return ResponseEntity.ok(
              new ResponseObject("Successful", "Found group", student));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body(new ResponseObject("Failed", "No found group", null));
    }
  }

  @Override
  public ResponseEntity<ResponseObject> chooseTopic(Integer topicId, Integer groupId) {
    try {
      //Initialize variables
      var group = groupRepo.findById(groupId).orElse(null);
      group.setProjectID(projectRepo.findById(topicId).orElse(null));

      logger.info("Choose topic");
      return ResponseEntity.ok(
              new ResponseObject("Successful", "Found group", groupRepo.save(group)));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body(new ResponseObject("Failed", "No found group", null));
    }
  }

//  private boolean checkExistedGroup(CreateGroupRequest g) {
//    return groupRepo.findById(g.getId()).orElse(null) != null;
//  }

  private Group addGroup(CreateGroupRequest g) {
    return groupRepo.save(
        Group.builder()
            .group_name(g.getName())
            .score(g.getScore())
            .classID(classRepo.findById(g.getClassID()).orElse(null))
            .projectID(projectRepo.findById(g.getProjectID()).orElse(null))
            .build());
  }

  //    @Override
  //    public ResponseEntity<ResponseObject> chooseTopic(String topic) {
  //        return null;
  //    }
}
