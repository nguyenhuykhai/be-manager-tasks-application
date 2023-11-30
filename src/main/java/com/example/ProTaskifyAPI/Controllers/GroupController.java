package com.example.ProTaskifyAPI.Controllers;

import com.example.ProTaskifyAPI.DTO.GroupDTO;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.Services.GroupService;
import com.example.ProTaskifyAPI.Services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/group")
public class GroupController {
    private final GroupService groupService;

    private final StudentService studentService;

    @PostMapping("/create/{studentId}")
    public ResponseEntity<ResponseObject> createGroup(@RequestBody GroupDTO group,
                                                      @PathVariable("studentId") int studentId){
        if(studentService.checkIfStudentInClass(studentId)){
            studentService.setLeader(studentId);
            return groupService.createGroup(group);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseObject("Failed", "Group is already existed", null));
    }

//    @PostMapping("/topic")
//    public String chooseTopic(@RequestBody String topic){
//        return groupService.chooseTopic();
//    }
}
