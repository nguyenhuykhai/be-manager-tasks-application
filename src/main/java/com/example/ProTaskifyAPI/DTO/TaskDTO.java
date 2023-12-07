package com.example.ProTaskifyAPI.DTO;

import com.example.ProTaskifyAPI.Models.Feature;
import com.example.ProTaskifyAPI.Models.StudentTask;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO {
    private int task_id;

    private String task_name;

    private boolean status;

    private String feedback;
    
    private String priority;
    
    private String description;
    
    private Set<StudentTask> studentTaskSet = new HashSet<>();
    
    private Feature feature;
}
