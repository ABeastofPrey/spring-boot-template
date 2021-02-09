package com.kuka.springtemplate.mapper;

import com.kuka.springtemplate.model.User;

import org.apache.ibatis.jdbc.SQL;

public class PermissionMapperProvider {
    public String findByUser(User user) {
        return new SQL() {
            {
                SELECT("p.id, p.permissionname");

                // FROM("users as u");
                FROM("permissions as p");
                FROM("user_role as ur");
                FROM("role_permission as rp");

                // WHERE("u.username = " + user.getUsername());
                AND();
                WHERE("ur.uid =2");
                AND();
                WHERE("ur.rid = rp.rid");
                AND();
                WHERE("p.id = rp.pid");
            }
        }.toString();
    }
}
