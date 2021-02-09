package com.kuka.springtemplate.service;

import java.util.List;

import com.kuka.springtemplate.model.Permission;
import com.kuka.springtemplate.model.User;

public interface PermissionService {
    List<Permission> findAll();
    List<Permission> findByUser(User user);
    Permission       findById(long id);
    long             createOne(Permission permission);
    long             updateOne(Permission permission);
    long             deleteOne(long id);
}
