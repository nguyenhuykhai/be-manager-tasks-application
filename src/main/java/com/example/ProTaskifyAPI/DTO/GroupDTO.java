package com.example.ProTaskifyAPI.DTO;

import com.example.ProTaskifyAPI.Models.Class;
import com.example.ProTaskifyAPI.Models.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDTO {

    private String group_id;

    private String group_name;

    private float score;

    private String project_id;

    private String classID;

    private ArrayList<Student> groupStudents;

    public GroupDTO(String group_id, String group_name, float score, String project_id, String classID) {
        this.group_id = group_id;
        this.group_name = group_name;
        this.score = score;
        this.project_id = project_id;
        this.classID = classID;
    }
}
