package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.Response.AuthenticationResponse;
import com.example.ProTaskifyAPI.DTO.Response.LoginResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.AuthenticationRequest;
import com.example.ProTaskifyAPI.DTO.StudentDTOV1;
import com.example.ProTaskifyAPI.Models.Student;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface AuthenticationService {
    ResponseEntity<AuthenticationResponse> register(StudentDTOV1 dto);

    ResponseEntity<LoginResponseObject> login(AuthenticationRequest request);

    void refresh(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void revokeAllStudentToken(Student student);
}
