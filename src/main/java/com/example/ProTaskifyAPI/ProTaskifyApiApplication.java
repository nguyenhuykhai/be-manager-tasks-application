package com.example.ProTaskifyAPI;

import com.example.ProTaskifyAPI.Models.*;
import com.example.ProTaskifyAPI.Models.Class;
import com.example.ProTaskifyAPI.Models.Process;
import com.example.ProTaskifyAPI.Repositories.*;
import com.example.ProTaskifyAPI.ServiceImpl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ProTaskifyApiApplication {
  private final StudentRepo studentRepo;
  private final StudentServiceImpl studentService;
  private final ProjectRepo projectRepo;
  private final LecturerRepo lecturerRepo;
  private final SemesterRepo semesterRepo;
  private final SprintRepo sprintRepo;
  private final FeatureRepo featureRepo;
  private final TaskRepo taskRepo;
  private final GroupRepo groupRepo;
  private final StudentTaskRepo studentTaskRepo;
  private final ClassRepo classRepo;
  private final ArrayList<Integer> classArray;
  private final PasswordEncoder passwordEncoder;
  private final ProcessRepo processRepo;
  private Date date;

  public static void main(String[] args) {
    SpringApplication.run(ProTaskifyApiApplication.class, args);
  }

  @Bean
  public CommandLineRunner initData() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        classArray.add(1);
        List<Class> classes = new ArrayList<>();
        Class class1 =
            Class.builder()
                .class_name("12A8")
                .semesterID(semesterRepo.findById(1).orElse(null))
                .lecturerID(lecturerRepo.findById(1).orElse(null))
                .build();
        classes.add(class1);
        Class class2 =
            Class.builder()
                .class_name("9.12")
                .semesterID(semesterRepo.findById(1).orElse(null))
                .lecturerID(lecturerRepo.findById(1).orElse(null))
                .build();
        classes.add(class2);
        classRepo.saveAll(classes);

        List<Student> students = new ArrayList<>();
        Student student1 =
            Student.builder()
                .score(3.2f)
                .about("")
                .link_facebook("https://www.facebook.com/hau.chu.334/")
                .github("https://github.com/RankillerDY")
                .email("abc1@gmail.com")
                .classID(classRepo.findById(1).orElse(null))
                .is_leader(false)
                .password(passwordEncoder.encode("123"))
                //						.pending(studentService.writeArrayToByteArray(classArray))
                .build();
        students.add(student1);

        Student student2 =
            Student.builder()
                .score(3.2f)
                .about("")
                .link_facebook("https://www.facebook.com/hau.chu.334/")
                .github("https://github.com/RankillerDY")
                .password("123")
                .email("abc2@gmail.com")
                .password(passwordEncoder.encode("123"))
                .classID(classRepo.findById(2).orElse(null))
                .is_leader(true)
                .build();
        students.add(student2);
        studentRepo.saveAll(students);

        List<Project> projects = new ArrayList<>();
        Project project1 =
            Project.builder()
                .project_name("Manhattan")
                .lecturerID(lecturerRepo.findById(1).orElse(null))
                .status(true)
                .problems("no problem")
                .context("The atomic boom")
                .functional_requirements("The explosion need to be 250ft tall")
                .non_functional_requirements("Destroy everything")
                .build();
        projects.add(project1);
        Project project2 =
            Project.builder()
                .project_name("Taskify")
                .lecturerID(lecturerRepo.findById(1).orElse(null))
                .status(true)
                .problems("no problem")
                .context("Help manage task")
                .functional_requirements("Able to settle things")
                .non_functional_requirements("high performance")
                .build();
        projects.add(project2);
        projectRepo.saveAll(projects);

        List<Sprint> sprints = new ArrayList<>();
        Sprint sprint1 =
            Sprint.builder()
                .end_date(date)
                .status(true)
                .feedback("Well done!")
                .sprint_name("Sprint number 1")
                .start_date(date)
                .build();
        sprints.add(sprint1);
        Sprint sprint2 =
            Sprint.builder()
                .end_date(date)
                .status(true)
                .feedback("Well done!")
                .sprint_name("Sprint number 2")
                .start_date(date)
                .build();
        sprints.add(sprint2);
        sprintRepo.saveAll(sprints);

        List<Feature> features = new ArrayList<>();
        Feature feature1 =
            Feature.builder()
                .description("Your future depends on what you do today")
                .feature_name("Feature 1")
                .build();
        features.add(feature1);
        Feature feature2 =
            Feature.builder()
                .description("Your future depends on what you do today")
                .feature_name("Feature 2")
                .build();
        features.add(feature2);
        featureRepo.saveAll(features);

        List<Task> tasks = new ArrayList<>();
        Task task1 =
            Task.builder()
                .description("Your future depends on what you do today")
                .feature(featureRepo.findById(1).orElse(null))
                .feedback("Well done!")
                .priority("Top prior")
                .status(true)
                .task_name("Task 1")
                .build();
        tasks.add(task1);
        Task task2 =
            Task.builder()
                .description("Your future depends on what you do today")
                .feature(featureRepo.findById(1).orElse(null))
                .feedback("Well done!")
                .priority("Top prior")
                .status(true)
                .task_name("Task 2")
                .build();
        tasks.add(task2);
        taskRepo.saveAll(tasks);

        List<StudentTask> studentTasks = new ArrayList<>();
        StudentTask studentTask1 =
            StudentTask.builder()
                .task(taskRepo.findById(1).orElse(null))
                .student(studentRepo.findById(1).orElse(null))
                .id(new StudentTaskCompositeKey(1, 1))
                .build();
        studentTasks.add(studentTask1);
        StudentTask studentTask2 =
            StudentTask.builder()
                .task(taskRepo.findById(2).orElse(null))
                .student(studentRepo.findById(2).orElse(null))
                .id(new StudentTaskCompositeKey(2, 2))
                .build();
        studentTasks.add(studentTask2);
        studentTaskRepo.saveAll(studentTasks);

        List<Group> groups = new ArrayList<>();
        Group group1 =
            Group.builder()
                .group_name("Group 1")
                .score(4.2f)
                .projectID(projectRepo.findById(1).orElse(null))
                .classID(classRepo.findById(1).orElse(null))
                .build();
        groups.add(group1);
        groupRepo.save(group1);

        List<Process> processes = new ArrayList<>();
        Process process1 =
            Process.builder()
                .feature(featureRepo.findById(1).orElse(null))
                .project(projectRepo.findById(1).orElse(null))
                .sprint(sprintRepo.findById(1).orElse(null))
                .id(new ProcessCompositeKey(1, 1, 1))
                .build();
        processes.add(process1);
        Process process2 =
            Process.builder()
                .feature(featureRepo.findById(2).orElse(null))
                .project(projectRepo.findById(1).orElse(null))
                .sprint(sprintRepo.findById(2).orElse(null))
                .id(new ProcessCompositeKey(1, 2, 2))
                .build();
        processes.add(process2);
        processRepo.saveAll(processes);
      }
    };
  }
}
