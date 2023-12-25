package com.example.ProTaskifyAPI.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TotalTasksResponse {
    private Integer total_tasks_pending;
    private Integer total_finished_tasks;
    private Integer total_late_tasks;
}
