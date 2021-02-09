package com.kuka.springtemplate.mapper;

import java.util.List;

import com.kuka.springtemplate.model.Role;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface RoleMapper {
    @Insert("INSERT INTO roles (rolename) VALUES (#{rolename})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Role Role);

    @Delete("DELETE FROM roles WHERE id = #{id}")
    int delete(Role role);

    @Update("UPDATE roles SET rolename = #{rolename} WHERE id = #{id}")
    int update(Role role);

    @Select("SELECT id, rolename FROM roles WHERE id = #{id}")
    @Results(id = "roleMap", value = {
        @Result(column = "id", property = "id", javaType = Long.class),
        @Result(column = "rolename", property = "rolename", javaType = String.class)
    })
    Role findById(long id);

    @Select("SELECT * FROM roles")
    @ResultMap("roleMap")
    List<Role> findAll();
}
