package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.DTO.MsgDTO;
import com.example.ProTaskifyAPI.DTO.StudentDTO;
import com.example.ProTaskifyAPI.Models.Student;
import com.example.ProTaskifyAPI.Repositories.StudentRepo;
import com.example.ProTaskifyAPI.Services.MsgService;
import com.example.ProTaskifyAPI.Services.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final StudentRepo studentRepo;
    @Override
    public MsgDTO checkIfStudentInClass(String studentID) {
        Student s = studentRepo.findById(studentID).orElse(null);
        logger.info("Student data: " + s.toString());
        if(s != null && s.getClassID().getClass_id() != null && !s.getClassID().getClass_id().isEmpty()){
            return MsgService.generateMsg("Passed", "");
        }
        return MsgService.generateMsg("Failed", "Student not yet in class, id: " + studentID);
    }

    @Override
    public void setLeader(String studentID) {
        Student s = studentRepo.findById(studentID).orElse(null);
        if(s != null){
            s.set_leader(true);
            studentRepo.save(s);
        }

    }

}
