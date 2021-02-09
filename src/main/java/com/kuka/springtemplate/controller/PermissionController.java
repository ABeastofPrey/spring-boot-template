package com.kuka.springtemplate.controller;

import java.util.List;

import com.kuka.springtemplate.common.util.Result;
import com.kuka.springtemplate.model.Permission;
import com.kuka.springtemplate.model.User;
import com.kuka.springtemplate.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @PostMapping("/byUser")
    // public ResponseEntity<Result> getPermissionByUser(@RequestBody User user) {
    public List<Permission> getPermissionByUser(@RequestBody User user) {
        return permissionService.findByUser(user);
        // return ResponseEntity.status(HttpStatus.OK)
        //     .header("content-type", "application/json")
        //     .body(
        //         new Result(HttpStatus.ACCEPTED, "ok")
        //     );
    }

    @GetMapping("/findAll") 
    public List<Permission> findAll() {
        return permissionService.findAll();
    }

    @GetMapping("/findById")
    public Permission findById(@RequestParam(value = "id", defaultValue = "1") long id) {
        return permissionService.findById(id);
    }
}
