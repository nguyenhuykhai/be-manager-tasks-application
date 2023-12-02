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
@Table(name = "lecturer")
@Builder
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lecturer_id;

    @Column(name = "lecturer_name", length = 50)
    private String lecturer_name;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "picture", nullable = false)
    @Lob
    private String picture;

    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "lecturerID")
    private Set<Class> classStudent = new HashSet<>();

    @OneToMany(mappedBy = "lecturerID")
    private Set<Project> projectSet = new HashSet<>();

    @OneToMany(mappedBy = "lecturer")
    private Set<Messages> messageSet = new HashSet<>();

}
