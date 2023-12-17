package com.example.ProTaskifyAPI.DTO.Resquest;

import java.util.Date;

import com.example.ProTaskifyAPI.Models.Sprint;
import com.example.ProTaskifyAPI.Models.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VotePointRequest {
    private Float hard_working;

    private Float good_knowledge;

    private Float team_working;

    private Float total;

    private String response_note;

    private Boolean status;

    private Integer sprint;

    private Integer student;
}
