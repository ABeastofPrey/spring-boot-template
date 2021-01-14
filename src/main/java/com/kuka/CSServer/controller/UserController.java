package com.kuka.CSServer.controller;

import java.util.List;
import com.kuka.CSServer.entity.User;
import com.kuka.CSServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import java.util.concurrent.atomic.AtomicLong;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired 
    private UserService userService;

    private final User user;

    public UserController() {
        user = new User();
        user.setId((long) 4);
        user.setUsername("Admin");
        user.setPassword("admin");
    }

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/findById")
    public User getUserById(@RequestParam(value = "id", defaultValue = "0") long id) {
        return userService.findById(id);
    }

    // private static final String template = "Hello, %s!";
    // private final AtomicLong counter = new AtomicLong();

    // @GetMapping("/greeting")
    // public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    //     return new Greeting(counter.incrementAndGet(), String.format(template, name));
    // }
}
