package com.kuka.springtemplate.service;

import java.util.List;

import com.kuka.springtemplate.model.Role;

public interface RoleService {
    List<Role> findAll();
    Role       findById(long id);
    long       createOne(Role role);
    long       updateOne(Role role);
    long       deleteOne(Role role);
}
