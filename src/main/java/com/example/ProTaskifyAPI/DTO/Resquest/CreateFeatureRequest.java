package com.example.ProTaskifyAPI.DTO.Resquest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFeatureRequest {
    private String feature_name;

    private String description;
}
