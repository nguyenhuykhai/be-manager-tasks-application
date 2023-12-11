package com.example.ProTaskifyAPI.DTO.Response;

import com.example.ProTaskifyAPI.Models.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessDetailsResponse {
    ProcessCompositeKey id;
    private Project project;
    private Sprint sprint;
    private Feature feature;
}
