package com.example.ProTaskifyAPI.Controllers;

import com.example.ProTaskifyAPI.DTO.GroupDTO;
import com.example.ProTaskifyAPI.DTO.MsgDTO;
import com.example.ProTaskifyAPI.Services.GroupService;
import com.example.ProTaskifyAPI.Services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/group")
public class GroupController {
    private final GroupService groupService;

    private final StudentService studentService;

    @PostMapping("/create/{studentId}")
    public MsgDTO createGroup(@RequestBody GroupDTO group,
                              @PathVariable("studentId") String studentId){
        MsgDTO msg = studentService.checkIfStudentInClass(studentId);
        if(msg.getMsgBody().isEmpty()){
            studentService.setLeader(studentId);
            return groupService.createGroup(group);
        }else {
            return msg;
        }
    }

    @PostMapping("/topic")
    public String chooseTopic(@RequestBody String topic){

        return null;
    }
}
