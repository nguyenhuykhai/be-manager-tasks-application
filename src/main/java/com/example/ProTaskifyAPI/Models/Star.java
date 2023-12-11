package com.example.ProTaskifyAPI.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "star")
@Builder
public class Star {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int star_id;

    @Column
    private float hard_working;

    @Column
    private float good_knowledge;

    @Column
    private float team_working;

    @Column
    private float total;

    @Column(length = 100)
    private String response_note;

    @Column
    private boolean status;

    @Column
    private Date change_status_time;

    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "student_id")
    private Student student;
}
