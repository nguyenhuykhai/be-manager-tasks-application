package com.example.ProTaskifyAPI.DTO;

import com.example.ProTaskifyAPI.Models.Class;
import com.example.ProTaskifyAPI.Models.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTOV2 {
    private Integer id;
    private String password;
    private String name;
    private Class classID;
    private Group groupID;
    private Float score;
    private String linkFacebook;
    private String email;
    private String github;
    private String skills;
    private String about;
    private String picture;
    private String status;
    private Boolean isLeader;

    public StudentDTOV2(Integer id, String name, Class classID, Group groupID, Float score, String linkFacebook, String email, String github, String skills, String about, String picture, String status, Boolean isLeader) {
        this.id = id;
        this.name = name;
        this.classID = classID;
        this.groupID = groupID;
        this.score = score;
        this.linkFacebook = linkFacebook;
        this.email = email;
        this.github = github;
        this.skills = skills;
        this.about = about;
        this.picture = picture;
        this.status = status;
        this.isLeader = isLeader;
    }
}
