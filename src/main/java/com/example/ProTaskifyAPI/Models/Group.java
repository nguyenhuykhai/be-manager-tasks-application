package com.example.ProTaskifyAPI.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "status", length = 50)
    private boolean status;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "project_id")
    private Project projectID;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "class_id")
    private Class classID;

    @OneToMany(mappedBy = "groupID")
    @JsonManagedReference
    private Set<Student> groupStudents = new HashSet<>();

    @OneToMany(mappedBy = "group")
    @JsonManagedReference
    private Set<Messages> messagesSet = new HashSet<>();
}
