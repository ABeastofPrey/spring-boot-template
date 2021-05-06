package com.kuka.springtemplate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    public String index(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        return "Hello spring boot template!!";
    }
}
