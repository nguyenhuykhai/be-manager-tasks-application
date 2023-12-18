package com.example.ProTaskifyAPI.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sprint")
@Builder
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sprint_id;

    @Column(name = "sprint_name", length = 50)
    private String sprint_name;

    @Column(name = "feedback", length = 100)
    private String feedback;

    @Column(name = "status", length = 100)
    private String status;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @OneToMany(mappedBy = "sprint")
    private Set<Process> processSet = new HashSet<>();

    @OneToMany(mappedBy = "sprint")
    private Set<Star> starSet = new HashSet<>();
}
