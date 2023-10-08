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
    private String id;

    private String name;

    private String email;

    private String picture;

    private boolean status;

    private ArrayList<Class> classStudent;

}
