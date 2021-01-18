package com.kuka.CSServer.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class RegisterRequest {
    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$", message = "Please input corrected phone number")
    private String mobile;

    @NotNull(message = "Name is required")
    @Size(min = 1, max = 20, message = "Name is between 1~20 charaters")
    private String nickname;

    @NotNull(message = "Password is required")
    @Size(min = 6, max = 16, message = "Password is between 6~16 charaters")
    private String password;
}
