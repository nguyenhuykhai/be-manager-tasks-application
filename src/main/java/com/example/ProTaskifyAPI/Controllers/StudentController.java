package com.example.ProTaskifyAPI.Controllers;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.UpdateLinkRequest;
import com.example.ProTaskifyAPI.ServiceImpl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentServiceImpl studentService;
    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/updatelink")
    public ResponseEntity<ResponseObject> updateLink(@RequestBody UpdateLinkRequest obj) {
        return studentService.updateLink(obj);
    }

    @GetMapping("/get-all")
    public ResponseEntity<ResponseObject> updateLink() {
        return studentService.getAll();
    }
}
