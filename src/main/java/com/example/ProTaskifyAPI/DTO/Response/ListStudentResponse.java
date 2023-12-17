package com.example.ProTaskifyAPI.DTO.Response;

public interface ListStudentResponse {
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
}
