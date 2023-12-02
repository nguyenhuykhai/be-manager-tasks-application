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
@Table(name = "project")
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int project_id;

    @Column(name = "project_name", length = 50)
    private String project_name;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturerID;

    @Column(name = "status")
    private boolean status;

    @Column(name = "problems", nullable = false)
    @Lob
    private String problems;

    @Column(name = "context", nullable = false)
    @Lob
    private String context;

    @Column(name = "functional_requirements", nullable = false)
    @Lob
    private String functional_requirements;

    @Column(name = "non_functional_requirements", nullable = false)
    @Lob
    private String non_functional_requirements;

    @OneToMany(mappedBy = "projectID")
    private Set<Group> projectSet = new HashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<Process> processSet = new HashSet<>();
}
