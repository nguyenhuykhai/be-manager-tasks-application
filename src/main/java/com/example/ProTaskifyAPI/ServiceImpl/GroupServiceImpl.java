package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.DTO.GroupDTO;
import com.example.ProTaskifyAPI.DTO.MsgDTO;
import com.example.ProTaskifyAPI.Models.Group;
import com.example.ProTaskifyAPI.Repositories.ClassRepo;
import com.example.ProTaskifyAPI.Repositories.GroupRepo;
import com.example.ProTaskifyAPI.Services.GroupService;
import com.example.ProTaskifyAPI.Services.MsgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepo groupRepo;

    private final ClassRepo classRepo;

    @Override
    public MsgDTO createGroup(GroupDTO g) {
        if(checkExistedGroup(g)){
            return MsgService.generateMsg("Fail", "Group is already existed");
        }else{
            addGroup(g);
            return MsgService.generateMsg("Successful", "Create group successfully");
        }
    }

    private boolean checkExistedGroup(GroupDTO g){
        return groupRepo.findById(g.getId()).orElse(null) != null;
    }

    private void addGroup(GroupDTO g){
        groupRepo.save(
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
    public MsgDTO chooseTopic(String topic) {
        return null;
    }
}
