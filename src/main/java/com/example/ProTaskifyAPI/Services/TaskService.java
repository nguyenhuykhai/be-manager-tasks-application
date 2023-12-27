package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.CreateTaskRequest;
import org.springframework.http.ResponseEntity;

public interface TaskService {
    void checkMissDeadline();

    ResponseEntity<ResponseObject> createTask(Integer featureId, CreateTaskRequest taskRequest);

    ResponseEntity<ResponseObject> submitTask(Integer taskId);

    ResponseEntity<ResponseObject> changeStatus_Finished(Integer taskId);
}
