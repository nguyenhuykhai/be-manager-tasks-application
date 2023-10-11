package com.example.ProTaskifyAPI.DTO;

import com.example.ProTaskifyAPI.Models.Class;
import com.example.ProTaskifyAPI.Models.Group;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {

    private int id;

    private String name;

    private int classID;

    private int groupID;

    private float score;

    private String linkFacebook;

    private String email;

    private String github;

    private String skills;

    private String about;

    private String picture;

    private String status;

    private boolean isLeader;
}
