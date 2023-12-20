package com.example.ProTaskifyAPI.DTO.Resquest;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateSprintRequest {
    private String sprint_name;

    private String feedback;

    private Date start_date;

    private Date end_date;
}
