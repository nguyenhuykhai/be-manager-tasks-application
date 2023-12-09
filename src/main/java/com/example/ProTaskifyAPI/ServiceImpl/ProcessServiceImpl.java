package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.DTO.Response.ProcessDetailsResponse;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import com.example.ProTaskifyAPI.Repositories.*;
import com.example.ProTaskifyAPI.Services.ProcessService;
import java.util.HashSet;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {
    private final Logger logger = LoggerFactory.getLogger(ProcessServiceImpl.class);
    
    private final ProcessRepo processRepo;

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
}
