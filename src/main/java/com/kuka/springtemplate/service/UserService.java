package com.kuka.springtemplate.service;

import java.util.List;
import com.kuka.springtemplate.entity.User;

public interface UserService {
    List<User> findAll();
    User       findById(long id);
    void       createOne(User user);
    void       deleteById(long id);
    void       updateOne(User user);
}
