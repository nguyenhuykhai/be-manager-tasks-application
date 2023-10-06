package com.example.ProTaskifyAPI.model;

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
    private String group_id;

    @Column(name = "group_name", length = 50)
    private String group_name;
    @Column(name = "score")
    private float score;

    private String project_id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classID;

    @OneToMany(mappedBy = "groupID")
    Set<Student> groupStudents = new HashSet<>();
}
