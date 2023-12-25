package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.DTO.Response.GroupProjectDetailsDTO;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.Repositories.*;
import com.example.ProTaskifyAPI.Services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final Logger logger = LoggerFactory.getLogger(ProcessServiceImpl.class);

    private final GroupRepo groupRepo;

    private final ClassRepo classRepo;

    private final ProjectRepo projectRepo;

    private final ProcessRepo processRepo;

    private final StudentRepo studentRepo;

    @Override
    public ResponseEntity<ResponseObject> findGroupProjectDetails(
            Integer group_id, Integer class_id) {
        try {
            //Initialize variables
            var group = groupRepo.findGroupProjectDetails(group_id, class_id).orElse(null);
            var process = processRepo.findGroupProjectDetails(group_id, class_id);
            var project = projectRepo.findGroupProjectDetails(group_id, class_id).orElse(null);
            var student = studentRepo.findGroupProjectDetails(group_id, class_id);
            //Build custom response
            GroupProjectDetailsDTO groupProjectDetailsDTO =
                    GroupProjectDetailsDTO.builder()
                            .group_id(group.getGroup_id())
                            .classID(group.getClassID())
                            .projectID(project)
                            .groupStudents(student)
                            .group_name(group.getGroup_name())
                            .score(group.getScore())
                            .build();
            logger.info("Return group details");
            //Set up entity
            groupProjectDetailsDTO.getProjectID().setProcessSet(process);


            return ResponseEntity.ok(
                    new ResponseObject("Successful", "Found group", groupProjectDetailsDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseObject("Failed", "No found group", null));
        }
    }

    @Override
    public ResponseEntity<ResponseObject> getAll_NonChoose_Project() {
        try {
            //Initialize variables
            var projects = projectRepo.getAll_NonChooseProjects();

            logger.info("Get non-choose all projects");
            return ResponseEntity.ok(
                    new ResponseObject("Successful", "Found projects", projects));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseObject("Failed", "No found group", null));
        }
    }
}
