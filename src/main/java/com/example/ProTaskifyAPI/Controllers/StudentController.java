package com.example.ProTaskifyAPI.Controllers;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.StudentDTO;
import com.example.ProTaskifyAPI.DTO.UpdateLinkRequest;
import com.example.ProTaskifyAPI.ServiceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final UserServiceImpl userService;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @PostMapping("/updatelink")
    public ResponseEntity<ResponseObject> updateLink(@RequestBody UpdateLinkRequest obj) {
        logger.info(obj.toString());
        return userService.updateLink(obj);
    }

}
