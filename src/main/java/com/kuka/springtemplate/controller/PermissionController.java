package com.kuka.springtemplate.controller;

import com.kuka.springtemplate.common.util.Result;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    // @PostMapping("/byUser")
    // public ResponseEntity<Result> getPermissionByUser() {
    //     return ResponseEntity.status(HttpStatus.OK)
    //         .header("content-type", "application/json")
    //         .body(
    //             new Result(HttpStatus.ACCEPTED, "ok")
    //         );
    // }
}
