package com.kuka.CSServer.service.impl;

import java.util.List;
import com.kuka.CSServer.entity.User;
import com.kuka.CSServer.mapper.UserMapper;
import com.kuka.CSServer.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired private UserMapper userMapper;
    @Override public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override public User findById(long id) {
        return userMapper.findById(id);
    }

    @Override public void createOne(User user) {
        userMapper.createOne(user);
    }

    @Override public void deleteById(long id) {
        userMapper.deleteById(id);
    }

    @Override public void updateOne(User user) {
        userMapper.updateOne(user);
    }
}
