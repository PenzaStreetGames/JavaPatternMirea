package com.hyberlet.study_1.controller;

import com.hyberlet.study_1.model.User;
import com.hyberlet.study_1.repository.UserRepository;
import com.hyberlet.study_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/users")
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users/me")
    public User getCurrent() {
        return userService.getCurrentUser();
    }
}
