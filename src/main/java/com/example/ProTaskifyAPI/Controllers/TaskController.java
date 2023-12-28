package com.example.ProTaskifyAPI.Controllers;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.CreateTaskRequest;
import com.example.ProTaskifyAPI.Services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    ResponseEntity<ResponseObject> createTask(
            @RequestParam(value = "featureId") Integer featureId,
            @RequestBody CreateTaskRequest taskRequest) {
        return taskService.createTask(featureId, taskRequest);
    }

    @PutMapping("/submit/verified")
    ResponseEntity<ResponseObject> submitTask(
            @RequestParam(value = "taskId") Integer taskId) {
        return taskService.submitTask(taskId);
    }

    @PutMapping("/submit/Finished")
    ResponseEntity<ResponseObject> commitTask(
            @RequestParam(value = "taskId") Integer taskId) {
        return taskService.changeStatus_Finished(taskId);
    }
}
