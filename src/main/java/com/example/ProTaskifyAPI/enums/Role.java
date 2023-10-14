package com.example.ProTaskifyAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
public enum Role {
    STUDENT(Set.of(
            Permission.STUDENT_READ,
            Permission.STUDENT_CREATE,
            Permission.STUDENT_UPDATE,
            Permission.STUDENT_DELETE
    )),
    LEADER(Set.of(
            Permission.STUDENT_READ,
            Permission.STUDENT_CREATE,
            Permission.STUDENT_UPDATE,
            Permission.STUDENT_DELETE,
            Permission.LEADER_READ,
            Permission.LEADER_CREATE,
            Permission.LEADER_UPDATE,
            Permission.LEADER_DELETE
    ));

    @Getter
    private final Set<Permission> permission;


}
