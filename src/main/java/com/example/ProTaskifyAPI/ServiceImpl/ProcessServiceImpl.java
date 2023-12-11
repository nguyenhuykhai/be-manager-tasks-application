package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.DTO.Response.ProcessDetailsResponse;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.Repositories.*;
import com.example.ProTaskifyAPI.Services.ProcessService;
import java.util.HashSet;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {
    private final Logger logger = LoggerFactory.getLogger(ProcessServiceImpl.class);
    
    private final ProcessRepo processRepo;

    private final JwtService jwtService;

    private final StudentRepo studentRepo;

    private final SprintRepo sprintRepo;

    private final StarRepo starRepo;

    private final TaskRepo taskRepo;

    @Override
    public ResponseEntity<ResponseObject> findProcessDetails(
            Integer group_id, Integer class_id) {
        try {
            var process = processRepo.findProcessDetails(group_id, class_id);

            for (ProcessDetailsResponse element : process) {
                var tasks = taskRepo.findTaskByFeature(element.getFeature());
                element.getFeature().setTaskSet(new HashSet<>(tasks));
            }
            logger.info("Return process details");
            return ResponseEntity.ok(
                    new ResponseObject("Successful", "Found group", process));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseObject("Failed", "No found group", null));
        }
    }

    @Override
    public ResponseEntity<ResponseObject> viewVotePage(int sprintId) {
        String token = ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest()
                .getHeader("Authorization")
                .substring(7);
        String email = jwtService.extractEmail(token);
        try {
            var student = studentRepo.findByEmail(email).orElse(null);
            var stars = starRepo.findStarsBySprintAndStudentNot(sprintRepo.findById(sprintId).orElse(null), student.getStudent_id());
            return ResponseEntity.ok(
                    new ResponseObject("Successful", "Found group", stars));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseObject("Failed", "No student found", null));
        }
    }
}
