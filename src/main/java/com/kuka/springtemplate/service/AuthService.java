package com.kuka.springtemplate.service;

import com.kuka.springtemplate.model.User;

public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
