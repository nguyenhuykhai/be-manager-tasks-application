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
    private String class_id;

    private String group_name;

    private String semester_id;

    private String lecturerID;

    private ArrayList<Student> classStudents;

    private ArrayList<Group> groupStudents;

    public ClassDTO(String class_id, String group_name, String semester_id, String lecturerID) {
        this.class_id = class_id;
        this.group_name = group_name;
        this.semester_id = semester_id;
        this.lecturerID = lecturerID;
    }
}
