package com.kuka.CSServer.entity;

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
}
