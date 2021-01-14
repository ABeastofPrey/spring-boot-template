package com.kuka.CSServer.service;

import java.util.List;
import com.kuka.CSServer.entity.User;

public interface UserService {
    List<User> findAll();
}
