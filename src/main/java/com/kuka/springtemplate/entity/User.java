package com.kuka.springtemplate.entity;

// import java.io.Serializable;

import lombok.AccessLevel;
// import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// @Data
@Setter(value = AccessLevel.PUBLIC)
@Getter
public class User {
    private Long id;
    private String username;
    private String password;

    public User() { super(); }

    public User(long id, String username, String password) {
        this.id       = id;
        this.username = username;
        this.password = password;
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
