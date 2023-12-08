package com.example.ProTaskifyAPI.DTO.Response;

import com.example.ProTaskifyAPI.Models.*;

import java.util.List;
import java.util.Set;

import com.example.ProTaskifyAPI.Models.Process;
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
