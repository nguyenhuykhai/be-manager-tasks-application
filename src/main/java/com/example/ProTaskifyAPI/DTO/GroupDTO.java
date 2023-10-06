package com.example.ProTaskifyAPI.DTO;

import com.example.ProTaskifyAPI.Models.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDTO {

    private String id;

    private String name;

    private float score;

    private String projectID;

    private String classID;

    private ArrayList<Student> groupStudents;
}
