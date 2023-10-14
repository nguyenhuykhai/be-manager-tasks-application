package com.example.ProTaskifyAPI.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    STUDENT_READ("student:read"),
    STUDENT_UPDATE("student:update"),
    STUDENT_CREATE("student:create"),
    STUDENT_DELETE("student:delete"),
    LEADER_READ("leader:read"),
    LEADER_UPDATE("leader:update"),
    LEADER_CREATE("leader:create"),
    LEADER_DELETE("leader:delete")
    ;

    @Getter
    private final String permission;


}
