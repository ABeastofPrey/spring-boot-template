package com.kuka.CSServer.mapper;

import java.util.List;
import com.kuka.CSServer.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User       findById(long id);
    void       createOne(User user);
}
