package com.kuka.springtemplate.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(LoginRequest.class);
    
    @Getter
    @Setter
	@NotNull(message="Account is required")
	@Pattern(regexp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$", message="Please give correct phone number")
	private String account;
    
    @Getter
    @Setter
    @NotNull(message="Password is required")
    @Size(min=6, max=16, message="Password must be 6~16 charaters")
	private String password;
    
    @Setter
	private boolean rememberMe;
	
	public boolean isRememberMe() {
		return rememberMe;
	}
}
