package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.DTO.GroupDTO;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.Models.Group;
import com.example.ProTaskifyAPI.Models.Student;
import com.example.ProTaskifyAPI.Repositories.ClassRepo;
import com.example.ProTaskifyAPI.Repositories.GroupRepo;
import com.example.ProTaskifyAPI.Services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepo groupRepo;

    private final ClassRepo classRepo;

    @Override
    public ResponseEntity<ResponseObject> createGroup(GroupDTO g) {
        if(checkExistedGroup(g)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseObject("Failed", "Group is already existed", null));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Successful", "Group successfully be created", addGroup(g)));
        }
    }

    private boolean checkExistedGroup(GroupDTO g){
        return groupRepo.findById(g.getId()).orElse(null) != null;
    }

    private Group addGroup(GroupDTO g){
        return groupRepo.save(
                new Group().builder()
                        .group_id(g.getId())
                        .group_name(g.getName())
                        .score(g.getScore())
                        .classID(classRepo.findById(g.getClassID()).orElse(null))
                        .project_id(g.getProjectID())
                        .build()
        );
    }

    @Override
    public ResponseEntity<ResponseObject> chooseTopic(String topic) {
        return null;
    }
}
