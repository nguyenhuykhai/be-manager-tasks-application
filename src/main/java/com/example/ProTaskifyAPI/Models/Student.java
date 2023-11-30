package com.example.ProTaskifyAPI.Models;

import com.example.ProTaskifyAPI.enums.Role;
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
  private Class classID;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group groupID;

  @Column(name = "score")
  private float score;

  @Column(name = "link_facebook", length = 100)
  private String link_facebook;

  @Column(name = "email", length = 50)
  private String email;

  @Column(name = "password", length = Integer.MAX_VALUE)
  private String password;

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

  @Column(name = "pending")
  private byte[] pending;

  @OneToMany(mappedBy = "user")
  private List<Tokens> tokens;

  @Override
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
    System.out.println("I'm Running");
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
