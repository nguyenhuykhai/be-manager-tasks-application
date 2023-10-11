package com.example.ProTaskifyAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateLinkRequest {
    private int student_id;
    private String link_facebook;
    private String github;
    private String email;
}
