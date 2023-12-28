package com.example.ProTaskifyAPI.Models;

import com.example.ProTaskifyAPI.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
@Builder
public class Student implements UserDetails {
  @Id
  @Column(name = "student_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int student_id;

  @Column(name = "student_name", length = 50)
  private String student_name;

  @ManyToOne
  @JoinColumn(name = "class_id")
//  @JsonBackReference
  private Class classID;

  @ManyToOne
//  @JsonBackReference
  @JoinColumn(name = "group_id")
  private Group groupID;

  @Column(name = "score")
  private float score;

  @Column(name = "link_facebook", length = 200)
  private String link_facebook;

  @Column(name = "email", length = 200)
  private String email;

  @Column(name = "password", length = Integer.MAX_VALUE)
  @JsonIgnore
  private String password;

  @Column(name = "github", length = 200)
  private String github;

  @Column(name = "skills", length = 200)
  private String skills;

  @Column(name = "about", length = 200)
  private String about;

  @Column(name = "picture")
  @Lob
  private String picture;

  @Column(name = "status")
  private String status;

  @Column(name = "is_leader")
  private boolean is_leader;

  @Column(name = "pending")
  private byte[] pending;

  @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
  @JsonManagedReference
  @JsonIgnore
  private List<Tokens> tokens;

  @OneToMany(mappedBy = "student")
  @JsonManagedReference
  private List<Star> starList;

  @OneToMany(mappedBy = "student")
  @JsonManagedReference
  private List<StudentTask> studentTaskList;

  @Override
  @JsonIgnore
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return grantedAuthorities();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public List<SimpleGrantedAuthority> grantedAuthorities() {
    System.out.println("GrantedAuthorities function in Student, I'm Running");
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    if(this.is_leader()) {
      Role.LEADER.getPermission().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getPermission())));
    }
    if(!this.is_leader()) {
      Role.STUDENT.getPermission().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getPermission())));
    }
    authorities.add(new SimpleGrantedAuthority("ROLE_" + (this.is_leader ? Role.LEADER.name() : Role.STUDENT.name())));
    return authorities;
  }

}
