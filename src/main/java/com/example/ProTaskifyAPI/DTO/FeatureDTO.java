package com.example.ProTaskifyAPI.DTO;

import com.example.ProTaskifyAPI.Models.Process;
import com.example.ProTaskifyAPI.Models.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureDTO {
    private int feature_id;

    private String feature_name;

    private String description;

    private Set<Process> processSet = new HashSet<>();

    private Set<Task> taskSet = new HashSet<>();
}
