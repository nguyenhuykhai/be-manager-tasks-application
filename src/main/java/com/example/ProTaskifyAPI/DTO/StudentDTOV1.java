package com.example.ProTaskifyAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTOV1 {
    private Integer id;
    private String password;
    private String name;
    private Integer classID;
    private Integer groupID;
    private Float score;
    private String linkFacebook;
    private String email;
    private String github;
    private String skills;
    private String about;
    private String picture;
    private String status;
    private Boolean isLeader;


}
