package com.example.ProTaskifyAPI.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProcessCompositeKey implements Serializable {
    @Column(name = "project")
    int project;

    @Column(name = "sprint")
    int sprint;

    @Column(name = "feature")
    int feature;
}
