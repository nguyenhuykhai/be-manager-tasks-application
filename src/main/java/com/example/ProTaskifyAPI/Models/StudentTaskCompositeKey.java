package com.example.ProTaskifyAPI.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
public class StudentTaskCompositeKey implements Serializable {
    @Column(name = "task")
    int task;

    @Column(name = "student")
    int student;
}
