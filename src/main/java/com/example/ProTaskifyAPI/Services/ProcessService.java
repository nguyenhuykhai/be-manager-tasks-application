package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface ProcessService {
    ResponseEntity<ResponseObject> findProcessDetails(Integer group_id, Integer class_id);
}
