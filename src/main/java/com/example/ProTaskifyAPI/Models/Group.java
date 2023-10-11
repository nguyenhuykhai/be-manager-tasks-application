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
@Table(name = "groups")
@Builder
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int group_id;

    @Column(name = "group_name", length = 50)
    private String group_name;
    @Column(name = "score")
    private float score;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project projectID;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classID;

    @OneToMany(mappedBy = "groupID")
    private Set<Student> groupStudents = new HashSet<>();
}
