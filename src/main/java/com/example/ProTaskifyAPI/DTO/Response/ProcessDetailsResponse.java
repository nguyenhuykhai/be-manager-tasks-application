package com.example.ProTaskifyAPI.DTO.Response;

import com.example.ProTaskifyAPI.Models.Feature;
import com.example.ProTaskifyAPI.Models.ProcessCompositeKey;
import com.example.ProTaskifyAPI.Models.Project;
import com.example.ProTaskifyAPI.Models.Sprint;

public class ProcessDetailsResponse {
    ProcessCompositeKey id;

    private Project project;

    private Sprint sprint;

    private Feature feature;


}
