package com.kuka.CSServer.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private Long id;

    private String username;

    private String mobile;

    private String password;

    private String role;

    public User(Long id, String username, String mobile, String password, String role) {
        this.id = id;
        this.username = username;
        this.mobile = mobile;
        this.password = password;
        this.role = role;
    }
}
