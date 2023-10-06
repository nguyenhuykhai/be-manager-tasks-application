package com.example.ProTaskifyAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
@Builder
public class Student {
  @Id
  @Column(name = "student_id")
  private String student_id;

  @Column(name = "student_name", length = 50)
  private String student_name;

  @ManyToOne
  @JoinColumn(name = "class_id")
  private Class classID;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group groupID;

  @Column(name = "score", nullable = false)
  private float score;

  @Column(name = "link_facebook", length = 100)
  private String link_facebook;

  @Column(name = "email", length = 50)
  private String email;

  @Column(name = "github", length = 50)
  private String github;

  @Column(name = "skills", length = 50)
  private String skills;

  @Column(name = "about", length = 100)
  private String about;

  @Column(name = "picture")
  @Lob
  private String picture;

  @Column(name = "status")
  private String status;

  @Column(name = "is_leader")
  private boolean is_leader;
}
