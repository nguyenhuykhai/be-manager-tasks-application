package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.CreateTaskRequest;
import com.example.ProTaskifyAPI.Models.*;
import com.example.ProTaskifyAPI.Models.Process;
import com.example.ProTaskifyAPI.Repositories.*;
import com.example.ProTaskifyAPI.Services.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
  private final TaskRepo taskRepo;
  private final ProcessRepo processRepo;
  private final ProjectRepo projectRepo;
  private final SprintRepo sprintRepo;
  private final FeatureRepo featureRepo;

  @Override
  //    @Scheduled(cron = "0 0 0 * * ?")
  @Transactional
  public void checkMissDeadline() {
    var listTasks = taskRepo.findAllMissDeadlineTasks();
    var listSprint = sprintRepo.findAllMissDeadlineSprints();
    for (Task task : listTasks) {
      task.setStatus("Miss Deadline");
    }
    for (Sprint sprint : listSprint) {
      sprint.setStatus("Miss Deadline");
    }
    for (Task task : listTasks) {
      var process =
          processRepo.findProcessByFeature(
              featureRepo.findById(task.getFeature().getFeature_id()).orElse(null));
      var processList =
          processRepo.findProcessesByProject(
              projectRepo
                  .findById(process.get(process.size() - 1).getId().getProject())
                  .orElse(null));
      for (int i = 0; i < processList.size(); i++) {
        if (process.get(process.size() - 1).getId().getSprint()
            < processList.get(i).getId().getSprint()) {
          Process newProcess =
              Process.builder()
                  .id(
                      ProcessCompositeKey.builder()
                          .sprint(processList.get(i).getId().getSprint())
                          .feature(process.get(process.size() - 1).getId().getFeature())
                          .project(process.get(process.size() - 1).getId().getProject())
                          .build())
                  .sprint(processList.get(i).getSprint())
                  .feature(process.get(process.size() - 1).getFeature())
                  .project(process.get(process.size() - 1).getProject())
                  .build();
          processRepo.save(newProcess);
          break;
        }
      }
    }

    sprintRepo.saveAll(listSprint);
    taskRepo.saveAll(listTasks);
  }

  @Override
  public ResponseEntity<ResponseObject> createTask(
      Integer featureId, CreateTaskRequest taskRequest) {
    try {
      var feature = featureRepo.findById(featureId).orElse(null);
      Task task =
          Task.builder()
              .task_name(taskRequest.getTask_name())
              .priority(taskRequest.getPriority())
              .feedback(taskRequest.getFeedback())
              .deleted(false)
              .description(taskRequest.getDescription())
              .status(taskRequest.getStatus())
              .feature(feature)
              .build();
      var savedTask = taskRepo.save(task);
      return ResponseEntity.ok(new ResponseObject("Successful", "Created task", savedTask));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ResponseObject("Failed", "Create failed", null));
    }
  }

  @Override
  public ResponseEntity<ResponseObject> submitTask(Integer taskId) {
    try {
      var task = taskRepo.findById(taskId).orElse(null);
      if(task != null) {
        task.setStatus("Verified");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("Successful", "Task status updated", null));
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("Failed", "Not found task", null));
      }

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
              .body(new ResponseObject("Failed", "Internal error", e.getMessage()));
    }

  }

  @Override
  public ResponseEntity<ResponseObject> changeStatus_Finished(Integer taskId) {
    try {
      var task = taskRepo.findById(taskId).orElse(null);
      if(task != null) {
        task.setStatus("Finished");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("Successful", "Task status updated", null));
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("Failed", "Not found task", null));
      }

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
              .body(new ResponseObject("Failed", "Internal error", e.getMessage()));
    }
  }
}
