package com.kuka.springtemplate.controller;

import java.util.List;

import com.kuka.springtemplate.common.util.Result;
import com.kuka.springtemplate.model.Role;
import com.kuka.springtemplate.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired private RoleService roleService;
    
    @GetMapping("/all")
    public ResponseEntity<Result> findAll() {
        List<Role> roles = roleService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
            .header("content-type", "application/json")
            .body(new Result(HttpStatus.ACCEPTED, "ok").putData("roles", roles));
    }

    @GetMapping("/findById") 
    public ResponseEntity<Result> findById(@RequestParam(value = "id", defaultValue = "0") long id) {
        Role role = roleService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
            .header("content-type", "application/json")
            .body(new Result(HttpStatus.ACCEPTED, "ok").putData("role", role));
    }
}
