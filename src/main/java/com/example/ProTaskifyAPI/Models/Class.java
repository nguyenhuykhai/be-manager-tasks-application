package com.example.ProTaskifyAPI.Models;

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
@Table(name = "class")
@Builder
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int class_id;

    @Column(name = "class_name", length = 50)
    private String class_name;

    @Column(name = "status", length = 50)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semesterID;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturerID;

    @OneToMany(mappedBy = "classID")
    @JsonManagedReference
    private Set<Student> classStudents = new HashSet<>();

    @OneToMany(mappedBy = "classID")
    @JsonManagedReference
    private Set<Group> groupStudents = new HashSet<>();

}
