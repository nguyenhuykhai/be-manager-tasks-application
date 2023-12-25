package com.example.ProTaskifyAPI.DTO.Resquest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTaskRequest {
    private String task_name;

    private String status;

    private String feedback;

    private String priority;

    private String description;
}
