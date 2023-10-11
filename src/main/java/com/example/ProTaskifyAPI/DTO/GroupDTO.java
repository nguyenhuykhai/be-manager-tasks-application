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

    private int id;

    private String name;

    private float score;

    private int projectID;

    private int classID;

    private ArrayList<Student> groupStudents;


}
