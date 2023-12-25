package com.example.ProTaskifyAPI.DTO;

import com.example.ProTaskifyAPI.Models.Process;
import com.example.ProTaskifyAPI.Models.Star;
import jakarta.persistence.*;
import java.util.Date;
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
public class SprintDTO {
    private int sprint_id;

    private String sprint_name;

    private String feedback;

    private String status;

    private boolean deleted;

    private Date start_date;

    private Date end_date;

    private Set<Process> processSet = new HashSet<>();

    private Set<Star> starSet = new HashSet<>();
}
