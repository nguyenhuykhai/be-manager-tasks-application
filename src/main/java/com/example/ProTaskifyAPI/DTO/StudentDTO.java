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

    private String student_id;

    private String student_name;

    private String classID;

    private String groupID;

    private float score;

    private String link_facebook;

    private String email;

    private String github;

    private String skills;

    private String about;

    private String picture;

    private String status;

    private boolean is_leader;

}
