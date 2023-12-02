package com.example.ProTaskifyAPI.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "status")
    private boolean status;

    @Column(name = "feedback", length = 100)
    private String feedback;

    @Column(name = "priority", length = 50)
    private String priority;

    @Column(name = "description", length = 100)
    private String description;

    @OneToMany(mappedBy = "task")
    private Set<StudentTask> studentTaskSet = new HashSet<>();
}
