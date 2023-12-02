package com.example.ProTaskifyAPI.Models;

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
@Table(name = "messages")
@Builder
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int message_id;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "request_note", length = 50)
    private String request_note;

    @Column(name = "create_note", nullable = false)
    @Lob
    private String create_note;

    @Column(name = "respone_note", length = 50)
    private String respone_note;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "change_status_time")
    private Date change_status_time;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
