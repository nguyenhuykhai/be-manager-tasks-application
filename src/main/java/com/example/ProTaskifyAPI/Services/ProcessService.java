package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.VotePointRequest;
import org.springframework.http.ResponseEntity;

public interface ProcessService {
    ResponseEntity<ResponseObject> findProcessDetails(Integer group_id, Integer class_id);

    ResponseEntity<ResponseObject> viewVotePage(int sprintId);

    ResponseEntity<ResponseObject> voteStudentStarPoints(VotePointRequest votePointRequest);
}
