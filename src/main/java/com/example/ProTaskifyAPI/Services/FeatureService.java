package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.GroupDTO;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface FeatureService {
    ResponseEntity<ResponseObject> createGroup(GroupDTO g);
}
