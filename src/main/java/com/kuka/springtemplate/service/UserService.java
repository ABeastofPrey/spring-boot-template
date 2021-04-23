package com.kuka.springtemplate.service;

import java.util.List;
import com.kuka.springtemplate.model.User;

public interface UserService {
    List<User> findAll();
    User       findById(long id);
    User       findByPhone(String phone);
    Long       createOne(User user);
    void       deleteById(long id);
    void       updateOne(User user);
}
