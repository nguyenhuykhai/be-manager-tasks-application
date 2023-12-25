package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.UpdateLinkRequest;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<ResponseObject> updateLink(UpdateLinkRequest dto);

    boolean checkIfStudentInClass(int studentID);

    void setLeader(int studentID);

    ResponseEntity<ResponseObject> getAll();

    ResponseEntity<ResponseObject> inviteGroup(int groupID, int studentID);

    ResponseEntity<ResponseObject> acceptInvitation(Integer groupID, Integer studentID);

    ResponseEntity<ResponseObject> getTotalTasksStatus(Integer ProjectID);

    ResponseEntity<ResponseObject> demandTask(Integer taskId, Integer studentId);

}
