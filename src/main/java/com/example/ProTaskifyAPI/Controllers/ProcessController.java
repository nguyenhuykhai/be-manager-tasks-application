package com.example.ProTaskifyAPI.Controllers;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.VotePointRequest;
import com.example.ProTaskifyAPI.ServiceImpl.ProcessServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/process")
public class ProcessController {
    private final ProcessServiceImpl processService;

    @GetMapping("/details")
    public ResponseEntity<ResponseObject> processDetails(@RequestParam(name = "groupId") int groupId,
                                                         @RequestParam(name = "classId") int classId) {
        return processService.findProcessDetails(groupId, classId);
    }

    @GetMapping("/view/vote")
    public ResponseEntity<ResponseObject> viewVotePage(@RequestParam(name = "sprintId") int sprintId) {
        return processService.viewVotePage(sprintId);
    }

    @PutMapping("/vote")
    public ResponseEntity<ResponseObject> voteStudentStarPoints(@RequestBody VotePointRequest votePointRequest) {
        return processService.voteStudentStarPoints(votePointRequest);
    }
}
