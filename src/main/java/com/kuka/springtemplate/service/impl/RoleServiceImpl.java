package com.kuka.springtemplate.service.impl;

import java.util.List;

import com.kuka.springtemplate.mapper.RoleMapper;
import com.kuka.springtemplate.model.Role;
import com.kuka.springtemplate.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> findAll() { return roleMapper.findAll(); }

    public Role findById(long id) { return roleMapper.findById(id); }

    public long createOne(Role role) { return roleMapper.insert(role); }

    public long updateOne(Role role) { return roleMapper.update(role); }

    public long deleteOne(Role role) { return roleMapper.delete(role); }
}
