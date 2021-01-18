package com.kuka.CSServer.service;

import com.kuka.CSServer.model.User;

public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
