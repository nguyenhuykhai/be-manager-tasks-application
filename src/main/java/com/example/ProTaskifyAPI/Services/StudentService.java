package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.MsgDTO;
import com.example.ProTaskifyAPI.DTO.StudentDTO;

public interface StudentService {
    MsgDTO checkIfStudentInClass(String studentID);

    void setLeader(String studentID);

}
