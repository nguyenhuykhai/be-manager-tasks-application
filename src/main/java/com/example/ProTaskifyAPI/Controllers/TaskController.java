package com.example.ProTaskifyAPI.Controllers;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.CreateTaskRequest;
import com.example.ProTaskifyAPI.Services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    ResponseEntity<ResponseObject> createTask(
            @RequestParam(value = "featureId") Integer featureId,
            @RequestBody CreateTaskRequest taskRequest) {
        return taskService.createTask(featureId, taskRequest);
    }
}
