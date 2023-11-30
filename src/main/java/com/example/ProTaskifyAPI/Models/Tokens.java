package com.example.ProTaskifyAPI.Models;

import com.example.ProTaskifyAPI.enums.TokenType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "token")
public class Tokens {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String token;
    @Enumerated(EnumType.STRING)
    private TokenType tokenType;

    private boolean expired;
    private boolean revoke;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Student user;

}
