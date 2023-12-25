package com.example.ProTaskifyAPI.DTO.Resquest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateGroupRequest {
    private String name;

    private float score;

    private int projectID;

    private int classID;
}
