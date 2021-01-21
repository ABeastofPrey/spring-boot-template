package com.kuka.springtemplate.model;

import lombok.Getter;
import lombok.Setter;

// import com.fasterxml.jackson.annotation.JsonProperty;
// import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
        // @JsonProperty(access = Access.WRITE_ONLY) //在输出的Json数据中隐藏密码，只能输入不输出
        this.password = password;
        this.role = role;
    }
}
