package com.example.ProTaskifyAPI.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "process")
@Builder
public class Process {
    @Id
    private int project_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    @Id
    @ManyToOne
    @JoinColumn(name = "feature")
    private Feature feature;
}
