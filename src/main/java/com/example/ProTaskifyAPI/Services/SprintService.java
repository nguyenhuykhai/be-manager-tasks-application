package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.CreateSprintRequest;
import org.springframework.http.ResponseEntity;

public interface SprintService {
    ResponseEntity<ResponseObject> createSprint(Integer projectId, CreateSprintRequest sprintRequest);
}
