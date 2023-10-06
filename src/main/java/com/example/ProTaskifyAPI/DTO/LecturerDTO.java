package com.example.ProTaskifyAPI.DTO;

import com.example.ProTaskifyAPI.Models.Class;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LecturerDTO {
    private String lecturer_id;

    private String lecturer_name;

    private String email;

    private String picture;

    private boolean status;

    private ArrayList<Class> classStudent;

    public LecturerDTO(String lecturer_id, String lecturer_name, String email, String picture, boolean status) {
        this.lecturer_id = lecturer_id;
        this.lecturer_name = lecturer_name;
        this.email = email;
        this.picture = picture;
        this.status = status;
    }
}
