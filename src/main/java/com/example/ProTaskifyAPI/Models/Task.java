package com.example.ProTaskifyAPI.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int task_id;

    @Column(name = "task_name", length = 50)
    private String task_name;

    @Column(name = "status", length = 100)
    private String status;

    @Column(name = "feedback", length = 100)
    private String feedback;

    @Column(name = "priority", length = 50)
    private String priority;

    @Column(name = "description", length = 100)
    private String description;

    @OneToMany(mappedBy = "task")
    private Set<StudentTask> studentTaskSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "feature_id")
    @JsonBackReference
    private Feature feature;
}
