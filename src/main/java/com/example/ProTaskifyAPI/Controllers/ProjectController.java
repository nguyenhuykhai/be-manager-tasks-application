package com.example.ProTaskifyAPI.Controllers;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.ServiceImpl.ProjectServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/project")
public class ProjectController {
    private final ProjectServiceImpl projectService;
    
    @GetMapping("/details")
    public ResponseEntity<ResponseObject> projectDetails(@RequestParam(name = "groupId") int groupId,
                                                       @RequestParam(name = "classId") int classId) {
        return projectService.findGroupProjectDetails(groupId, classId);
    }
}
