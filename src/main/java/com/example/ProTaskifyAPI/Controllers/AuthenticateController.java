package com.example.ProTaskifyAPI.Controllers;

import com.example.ProTaskifyAPI.DTO.Response.AuthenticationResponse;
import com.example.ProTaskifyAPI.DTO.Response.LoginResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.AuthenticationRequest;
import com.example.ProTaskifyAPI.DTO.StudentDTOV1;
import com.example.ProTaskifyAPI.ServiceImpl.AuthenticationServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/authenticate")
public class AuthenticateController {
    private final Logger logger = LoggerFactory.getLogger(AuthenticateController.class);
    private final AuthenticationServiceImpl services;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody StudentDTOV1 request
    ) {
        logger.info("The request information" + request);
        return services.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseObject> register(
            @RequestBody AuthenticationRequest request
    ) {
        return services.login(request);
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        services.refresh(request, response);
    }


}
