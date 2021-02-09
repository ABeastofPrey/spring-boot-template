package com.kuka.springtemplate.controller;

import java.util.List;

import com.kuka.springtemplate.model.Role;
import com.kuka.springtemplate.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired private RoleService roleService;
    
    @GetMapping("/findAll")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/findById") 
    public Role findById(@RequestParam(value = "id", defaultValue = "0") long id) {
        return roleService.findById(id);
    }
}
