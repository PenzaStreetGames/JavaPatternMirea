package com.hyberlet.task15.controller;

import com.hyberlet.task15.service.UserService;
import com.hyberlet.task15.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public void create() {
        System.out.println("aaa");
        User user = new User();
        user.setFirstName("Vasya");
        user.setLastName("Dima");
        userService.saveUser(user);
    }
}
