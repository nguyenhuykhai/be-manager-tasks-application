package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface ProjectService {
    ResponseEntity<ResponseObject> findGroupProjectDetails(Integer group_id, Integer class_id);

    ResponseEntity<ResponseObject> getAll_NonChoose_Project();
}
