package com.kuka.springtemplate.mapper;

import java.util.List;

import com.kuka.springtemplate.model.Permission;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PermissionMapper {
    @Insert("INSERT INTO permissions (permissionname) VALUES (#{permissionname})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Permission permission);

    @Delete("DELETE FROM permissions WHERE id = #{id}")
    int delete(Permission permission);

    @Update("UPDATE permissions SET permissionname = #{permissionname} WHERE id = #{id}")
    int update(Permission permission);

    @Select("SELECT id, permissionname FROM permissions WHERE id = #{id}")
    @Results(id = "permissionMap", value = {
        @Result(column = "id", property = "id", javaType = Long.class),
        @Result(column = "permissionname", property = "permissionname", javaType = String.class)
    })
    Permission findById(long id);

    @Select("SELECT * FROM permissions")
    @ResultMap("permissionMap")
    List<Permission> findAll();
}
