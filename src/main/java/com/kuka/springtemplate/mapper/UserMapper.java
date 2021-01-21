package com.kuka.springtemplate.mapper;

import java.util.List;
import com.kuka.springtemplate.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User       findById(long id);
    void       createOne(User user);
    void       deleteById(long id);
    void       updateOne(User user);
}
