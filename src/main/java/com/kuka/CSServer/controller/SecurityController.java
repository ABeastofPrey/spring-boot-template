package com.kuka.CSServer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @Value("${profile.name}")
    private String profileName;
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value="/hello1", method=RequestMethod.GET)
    public String hello1() {
        return "Hello1!";
    }

    @RequestMapping(value="/hello2", method=RequestMethod.GET)
    public String hello2() {
        return "Hello2!";
    }

    @RequestMapping(value="/hello3", method=RequestMethod.GET)
    public String hello3() {
        return "Hello3! " + profileName + " Runing on port: " + serverPort;
    }
}
