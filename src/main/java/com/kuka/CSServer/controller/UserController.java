package com.kuka.CSServer.controller;

import java.util.List;

import com.kuka.CSServer.entity.User;
import com.kuka.CSServer.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    // @PostMapping("/create")
    // public User creatUser(@RequestParam("username") String username, @RequestParam("password") String password) {
    //     System.out.println(username + " " + password);
    //     return this.user;
    // }

    // @PostMapping("/create")
    // public User creatUser(@RequestParam Map<String, String> params) {
    //     System.out.println(params.get("username") + " " + params.get("password"));
    //     return this.user;
    // }

    // @PostMapping("/create")
    // public User creatUser(User user) {
    //     System.out.println(user.getUsername() + " " + user.getPassword());
    //     return this.user;
    // }


    // For json data
    // @PostMapping("/create")
    // public User creatUser(@RequestBody Map<String, String> params) {
    //     System.out.println(params.get("username") + " " + params.get("password"));
    //     return this.user;
    // }

    @PostMapping("/createOne")
    public User creatOneUser(@RequestBody User user) {
        userService.createOne(user);
        return user;
    }

    @PostMapping("/createMany")
    public User creatManyUser(@RequestBody List<User> users) {
        String result = "";
        for(User user:users){
            result += user.getUsername() + " " + user.getPassword() + "\n";
        }
        System.out.println(result);
        return this.user;
    }

    @DeleteMapping("/deleteById")
    public String deleteUserById(@RequestParam("id") long id) {
        userService.deleteById(id);
        return "deleted";
    }

    // private static final String template = "Hello, %s!";
    // private final AtomicLong counter = new AtomicLong();

    // @GetMapping("/greeting")
    // public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    //     return new Greeting(counter.incrementAndGet(), String.format(template, name));
    // }
}
