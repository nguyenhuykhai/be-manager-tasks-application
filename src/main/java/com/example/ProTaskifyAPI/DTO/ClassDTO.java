package com.example.ProTaskifyAPI.DTO;

import com.example.ProTaskifyAPI.Models.Group;
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
public class ClassDTO {
    private String id;

    private String name;

    private String semesterID;

    private String lecturerID;

    private ArrayList<Student> classStudents;

    private ArrayList<Group> groupStudents;
}
