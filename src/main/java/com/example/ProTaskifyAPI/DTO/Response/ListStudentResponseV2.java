package com.example.ProTaskifyAPI.DTO.Response;

import com.example.ProTaskifyAPI.Models.Class;
import com.example.ProTaskifyAPI.Models.Group;

public interface ListStudentResponseV2 {
    int getStudent_id();

    String getStudent_name();

    float getScore();

    String getLink_facebook();

    String getEmail();

    String getGithub();

    String getSkills();

    String getAbout();

    String getPicture();

    String getStatus();

    boolean isIs_leader();

    Class getClass_id();

    Group getGroup_id();
}
