package com.kuka.springtemplate.service.impl;

import java.util.List;
import com.kuka.springtemplate.model.User;
import com.kuka.springtemplate.mapper.UserMapper;
import com.kuka.springtemplate.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired private UserMapper userMapper;
    @Override public List<User> findAll() {
        return userMapper.findAll();
    }

    // @Cacheable(value = "user", key = "#id") // 表明对应方法的返回结果可以被缓存，首次调用后，下次就从缓存中读取结果，方法不会再被执行了。
    @Override public User findById(long id) {
        return userMapper.findById(id);
    }

    @Override public void createOne(User user) {
        userMapper.createOne(user);
    }

    @Override public void deleteById(long id) {
        userMapper.deleteById(id);
    }

    @CacheEvict(value = "user", key= "#user.id") // 清除缓存，方法每次都会执行
    @Override public void updateOne(User user) {
        userMapper.updateOne(user);
    }
}
