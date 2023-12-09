package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.DTO.GroupDTO;
import com.example.ProTaskifyAPI.DTO.Response.GroupProjectDetailsDTO;
import com.example.ProTaskifyAPI.DTO.Response.ProcessDetailsResponse;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.Models.Group;
import com.example.ProTaskifyAPI.Models.Task;
import com.example.ProTaskifyAPI.Repositories.*;
import com.example.ProTaskifyAPI.Services.GroupService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
  private final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);

  private final GroupRepo groupRepo;

  private final ClassRepo classRepo;

  private final ProjectRepo projectRepo;

  private final ProcessRepo processRepo;

  private final FeatureRepo featureRepo;

  private final TaskRepo taskRepo;
  @Override
  public ResponseEntity<ResponseObject> createGroup(GroupDTO g) {
    if (checkExistedGroup(g)) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body(new ResponseObject("Failed", "Group is already existed", null));
    } else {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new ResponseObject("Successful", "Group successfully be created", addGroup(g)));
    }
  }

  @Override
  public ResponseEntity<ResponseObject> findGroupProjectDetails(
          Integer group_id, Integer class_id) {
    try {
      //Initialize variables
      var group = groupRepo.findGroupProjectDetails(group_id, class_id).orElse(null);
      var process = processRepo.findGroupProjectDetails(group_id, class_id);
      var project = projectRepo.findGroupProjectDetails(group_id, class_id).orElse(null);
      //Build custom response
      GroupProjectDetailsDTO groupProjectDetailsDTO =
              GroupProjectDetailsDTO.builder()
                      .group_id(group.getGroup_id())
                      .classID(group.getClassID())
                      .groupStudents(group.getGroupStudents())
                      .projectID(project)
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

  private boolean checkExistedGroup(GroupDTO g) {
    return groupRepo.findById(g.getId()).orElse(null) != null;
  }

  private Group addGroup(GroupDTO g) {
    return groupRepo.save(
        Group.builder()
            .group_id(g.getId())
            .group_name(g.getName())
            .score(g.getScore())
            .classID(classRepo.findById(g.getClassID()).orElse(null))
            .projectID(projectRepo.findById(g.getProjectID()).orElse(null))
            .build());
  }

  //    @Override
  //    public ResponseEntity<ResponseObject> chooseTopic(String topic) {
  //        return null;
  //    }
}
