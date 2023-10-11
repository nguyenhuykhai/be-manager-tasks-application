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
@Table(name = "semester")
@Builder
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int semester_id;

    @Column(name = "semester_name", length = 50)
    private String semester_name;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "semesterID")
    private Set<Class> classSet = new HashSet<>();

}
