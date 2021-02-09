package com.kuka.springtemplate.service;

import java.util.List;

import com.kuka.springtemplate.model.Permission;

public interface PermissionService {
    List<Permission> findAll();
    Permission       findById(long id);
    long             createOne(Permission permission);
    long             updateOne(Permission permission);
    long             deleteOne(Permission permission);
}
