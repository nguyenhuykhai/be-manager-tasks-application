package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.StudentDTO;
import com.example.ProTaskifyAPI.DTO.UpdateLinkRequest;
import com.example.ProTaskifyAPI.Models.Student;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface StudentService {
  ResponseEntity<ResponseObject> updateLink(UpdateLinkRequest dto);
}
