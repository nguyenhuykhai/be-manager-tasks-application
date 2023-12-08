package com.example.ProTaskifyAPI.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "feature")
@Builder
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int feature_id;

    @Column(name = "feature_name", length = 50)
    private String feature_name;

    @Column(name = "description", length = 100)
    private String description;

    @OneToMany(mappedBy = "feature")
    private Set<Process> processSet = new HashSet<>();

    @OneToMany(mappedBy = "feature", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Task> taskSet = new HashSet<>();
}
