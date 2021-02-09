package com.kuka.springtemplate.service.impl;

import java.util.List;

import com.kuka.springtemplate.mapper.PermissionMapper;
import com.kuka.springtemplate.model.Permission;
import com.kuka.springtemplate.model.User;
import com.kuka.springtemplate.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired private PermissionMapper permissionMapper;

    public List<Permission> findAll() { return permissionMapper.findAll(); }

    public List<Permission> findByUser(User user) { return permissionMapper.findByUser(user); }

    public Permission findById(long id) { return permissionMapper.findById(id); }

    public long createOne(Permission permission) { return permissionMapper.insert(permission); }

    public long updateOne(Permission permission) { return permissionMapper.update(permission); }

    public long deleteOne(long id) { return permissionMapper.deleteById(id); }
}
