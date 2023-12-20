package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.GroupDTO;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.CreateFeatureRequest;
import org.springframework.http.ResponseEntity;

public interface FeatureService {
    ResponseEntity<ResponseObject> createFeature(Integer sprintId, Integer projectId, CreateFeatureRequest createRequest);
}
