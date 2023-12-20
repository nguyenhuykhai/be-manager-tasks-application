package com.example.ProTaskifyAPI.Controllers;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.CreateSprintRequest;
import com.example.ProTaskifyAPI.Services.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/sprint")
public class SprintController {
    private final SprintService sprintService;

    @PostMapping("/create")
    ResponseEntity<ResponseObject> createSprint(
            @RequestParam(value = "projectId") Integer projectId,
            @RequestBody CreateSprintRequest sprintRequest) {
        return sprintService.createSprint(projectId, sprintRequest);
    }
}
