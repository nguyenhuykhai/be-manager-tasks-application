package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.DTO.UpdateLinkRequest;
import com.example.ProTaskifyAPI.Models.Student;
import com.example.ProTaskifyAPI.Repositories.StudentRepo;
import com.example.ProTaskifyAPI.Services.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final StudentRepo studentRepo;

    @Override
    public boolean checkIfStudentInClass(int studentID) {
        Student s = studentRepo.findById(studentID).orElse(null);

        if (s != null && s.getClassID() != null) {
            return true;
        }
        return false;
    }

    @Override
    public void setLeader(int studentID) {
        Student s = studentRepo.findById(studentID).orElse(null);
        if (s != null) {
            s.set_leader(true);
            studentRepo.save(s);
        }

    }

    @Override
    public ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.ok().body(new ResponseObject("Successful", "Get all student", studentRepo.findAll()));
    }


    @Override
    public ResponseEntity<ResponseObject> updateLink(UpdateLinkRequest obj) {
        Student student = studentRepo.findById(obj.getStudent_id()).orElse(null);
        if (student != null) {
            if (isValidLinkFacebook(obj.getLink_facebook())) {
                student.setLink_facebook(obj.getLink_facebook());
            }
            if (isValidLinkGitHub(obj.getGithub())) {
                student.setGithub(obj.getGithub());
            }
            if (isValidLinkEmail(obj.getEmail())) {
                student.setEmail(obj.getEmail());
            }
            return ResponseEntity.ok(new ResponseObject("Successful", "The link has been updated", studentRepo.save(student)));
        }


        return ResponseEntity.ok(new ResponseObject("Failed", "The link hasn't been updated due to wrong format", student));
    }

    public boolean isValidLinkFacebook(String url) {
        try {
            URL facebook = new URL(url);
            if (!url.isEmpty() && facebook.toString().contains("facebook.com")) {
                HttpURLConnection connection = (HttpURLConnection) facebook.openConnection();
                connection.setRequestMethod("HEAD");
                int responseCode = connection.getResponseCode();
                return (responseCode >= 200 && responseCode < 300);
            } else {
                throw new IOException("Incorrect url format");
            }

        } catch (IOException e) {

            return false;
        }
    }

    public boolean isValidLinkGitHub(String url) {
        try {
            URL gitHub = new URL(url);
            if (!url.isEmpty() && gitHub.toString().contains("github.com")) {
                HttpURLConnection connection = (HttpURLConnection) gitHub.openConnection();
                connection.setRequestMethod("HEAD");
                int responseCode = connection.getResponseCode();
                return (responseCode >= 200 && responseCode < 300);
            } else {
                throw new IOException("Incorrect url format");
            }

        } catch (IOException e) {

            return false;
        }
    }

    public boolean isValidLinkEmail(String email) {
        if (email.contains("@gmail.com")) {
            return true;
        }

        return false;
    }

}
