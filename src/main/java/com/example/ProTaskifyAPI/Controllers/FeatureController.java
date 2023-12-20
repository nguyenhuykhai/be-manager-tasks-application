package com.example.ProTaskifyAPI.Controllers;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.CreateFeatureRequest;
import com.example.ProTaskifyAPI.Services.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/feature")
public class FeatureController {
    private final FeatureService featureService;
    
    @PostMapping("/create")
    ResponseEntity<ResponseObject> createSprint(
            @RequestParam(value = "projectId") Integer projectId,
            @RequestParam(value = "sprintId") Integer sprintId,
            @RequestBody CreateFeatureRequest createFeatureRequest) {
        return featureService.createFeature(sprintId, projectId, createFeatureRequest);
    }
}
