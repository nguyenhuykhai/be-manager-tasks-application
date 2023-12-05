package com.example.ProTaskifyAPI.DTO.Response;

import com.example.ProTaskifyAPI.Models.Class;
import com.example.ProTaskifyAPI.Models.Process;
import com.example.ProTaskifyAPI.Models.Project;
import com.example.ProTaskifyAPI.Models.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupProjectDetailsDTO {
    private int group_id;

    private String group_name;

    private float score;

    private Project projectID;

    private Class classID;

    private Set<Student> groupStudents;
}
