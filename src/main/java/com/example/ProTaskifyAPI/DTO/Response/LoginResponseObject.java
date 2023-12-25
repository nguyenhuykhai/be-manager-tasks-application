package com.example.ProTaskifyAPI.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseObject {
    private String status;
    private String message;
    private Object payload;
    private Object student;
}
