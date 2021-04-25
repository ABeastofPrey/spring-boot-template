package com.kuka.springtemplate.controller;

import java.util.List;

import javax.annotation.Resource;

import com.kuka.springtemplate.common.util.Result;
import com.kuka.springtemplate.model.User;
import com.kuka.springtemplate.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/user")
public class UserController {
    @Autowired 
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redis;

    public UserController() { }

    @RequestMapping("/hi")
    public ResponseEntity<Result> hello() {
        return ResponseEntity.status(HttpStatus.OK)
        .header("content-type", "application/json")
        .body(new Result(HttpStatus.OK, "Some Message"));
    }

    @GetMapping("/all")
    public ResponseEntity<Result> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
            .header("content-type", "application/json")
            .body(new Result(HttpStatus.OK, "ok").putData("users", users));
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public User getUserById(@RequestParam(value = "id", defaultValue = "0") long id) {
        return userService.findById(id);
    }

    @GetMapping("/findByPhone")
    public ResponseEntity<Result> getUserByPhone(@RequestParam(value = "phone") String phone) {
        User user = userService.findByPhone(phone);
        return ResponseEntity.status(HttpStatus.OK)
            .header("content-type", "application/json")
            .body(new Result(HttpStatus.OK, "ok").putData("user", user));
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
    public Long creatOneUser(@RequestBody User user) {
        long insert = userService.createOne(user);
        System.out.println("执行成功条数: " + insert);
        return user.getId();
    }

    @PostMapping("/createMany")
    public void creatManyUser(@RequestBody List<User> users) {
        String result = "";
        for(User user:users){
            result += user.getUsername() + " " + user.getPassword() + "\n";
        }
        System.out.println(result);
        // return this.user;
    }

    @DeleteMapping("/deleteById")
    public String deleteUserById(@RequestParam("id") long id) {
        userService.deleteById(id);
        return "deleted";
    }

    @PutMapping("/updateOne")
    public String updateOne(@RequestBody User user) {
        userService.updateOne(user);
        return "updated";
    }

    // private static final String template = "Hello, %s!";
    // private final AtomicLong counter = new AtomicLong();

    // @GetMapping("/greeting")
    // public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    //     return new Greeting(counter.incrementAndGet(), String.format(template, name));
    // }

    @RequestMapping("/redis")
    public String redis() throws Exception {
        String key = "project-name";
        redis.opsForValue().set(key, "spring-boot-redis-demo-value");

        String value = (String) redis.opsForValue().get(key);

        return value;
    }
}
