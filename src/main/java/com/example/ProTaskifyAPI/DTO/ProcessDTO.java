package com.example.ProTaskifyAPI.DTO;

import com.example.ProTaskifyAPI.Models.Feature;
import com.example.ProTaskifyAPI.Models.ProcessCompositeKey;
import com.example.ProTaskifyAPI.Models.Project;
import com.example.ProTaskifyAPI.Models.Sprint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessDTO {
    ProcessCompositeKey id;
    
    private Project project;
    
    private Sprint sprint;
    
    private Feature feature;
}
