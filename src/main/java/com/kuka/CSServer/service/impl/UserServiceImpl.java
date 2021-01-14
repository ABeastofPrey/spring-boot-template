package com.kuka.CSServer.service.impl;

import java.util.List;
import com.kuka.CSServer.entity.User;
import com.kuka.CSServer.mapper.UserMapper;
import com.kuka.CSServer.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        User user = new User();
        user.setId((long) 4);
        user.setUsername("Admin");
        user.setPassword("admin");
        List<User> users = userMapper.findAll();
        users.add(user);
        return users;
    }
}
