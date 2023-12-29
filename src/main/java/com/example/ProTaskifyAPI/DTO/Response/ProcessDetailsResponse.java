package com.example.ProTaskifyAPI.DTO.Response;

import com.example.ProTaskifyAPI.Models.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcessDetailsResponse {
    ProcessCompositeKey id;
    private Project project;
    private Sprint sprint;
    private Feature feature;
}
