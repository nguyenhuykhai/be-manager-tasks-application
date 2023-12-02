package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.DTO.Response.AuthenticationResponse;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.Resquest.AuthenticationRequest;
import com.example.ProTaskifyAPI.DTO.StudentDTO;
import com.example.ProTaskifyAPI.Models.Student;
import com.example.ProTaskifyAPI.Models.Tokens;
import com.example.ProTaskifyAPI.Repositories.StudentRepo;
import com.example.ProTaskifyAPI.Repositories.TokensRepo;
import com.example.ProTaskifyAPI.Services.AuthenticationService;
import com.example.ProTaskifyAPI.enums.TokenType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final StudentRepo studentRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final TokensRepo tokensRepo;

    @Override
    public ResponseEntity<AuthenticationResponse> register(StudentDTO dto) {
        try {
            Student stu = Student.builder()
                    .student_name(dto.getName())
                    .status("Active")
                    .email(dto.getEmail())
                    .github(dto.getGithub())
                    .link_facebook(dto.getLinkFacebook())
                    .password(passwordEncoder.encode(dto.getPassword()))
                    .skills(dto.getSkills())
                    .build();
            var savedUser = studentRepo.save(stu);
            var jwtToken = jwtService.generateToken(stu);
            var refreshToken = jwtService.generateRefreshToken(stu);
            SavedUserToken(jwtToken, savedUser);
            return ResponseEntity.ok().body(new AuthenticationResponse("Successful", jwtToken, refreshToken));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthenticationResponse("Failed", "Register failed", null));
        }

    }

    @Override
    public ResponseEntity<ResponseObject> login(AuthenticationRequest request) {
        try {
            var authenticatedUser = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            var user = studentRepo.findByEmail(request.getEmail()).orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            revokeAllStudentToken(user);
            SavedUserToken(jwtToken, user);
            return ResponseEntity.ok().body(new ResponseObject("Successful", "Jwt token: " + jwtToken, authenticatedUser));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("Failed", "Login failed", null));

        }

    }

    @Override
    public void refresh(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String email;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        email = jwtService.extractEmail(refreshToken);
        if (email != null) {
            UserDetails userDetails = this.studentRepo.findByEmail(email).orElseThrow();
            if (jwtService.isValidToken(refreshToken, userDetails)) { //if the refresh token expired then the user need to log in again
                var accessToken = jwtService.generateToken(userDetails);
                var authResponse = AuthenticationResponse.builder()
                        .status("Successful")
                        .token(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    @Override
    public void revokeAllStudentToken(Student student) {
        var validToken = tokensRepo.findAllValidTokenByUser(student.getStudent_id());
        if(validToken.isEmpty()) return;
        validToken.forEach(t -> {
            t.setExpired(true);
            t.setRevoke(true);
        });
        tokensRepo.saveAll(validToken);
    }

    private void SavedUserToken(String jwtToken, Student savedUser) {
        Tokens token = Tokens.builder()
                .token(jwtToken)
                .student(savedUser)
                .tokenType(TokenType.BEARER)
                .revoke(false)
                .expired(false)
                .build();
        tokensRepo.save(token);
    }

}
