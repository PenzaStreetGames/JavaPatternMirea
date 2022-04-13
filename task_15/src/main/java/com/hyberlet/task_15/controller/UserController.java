package com.hyberlet.task_15.controller;

import com.hyberlet.task_15.service.UserService;
import com.hyberlet.task_15.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Data
    static class DeleteQueryBody {
        private Long id;
    }

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public boolean create(@RequestBody User user) {
        System.out.println(user.getFirstName() + " " + user.getLastName());
        userService.saveUser(user);
        return true;
    }

    @DeleteMapping("/users")
    public boolean delete(@RequestBody DeleteQueryBody body) {
        System.out.println(body.getId());
        userService.deleteUserById(body.getId());
        return true;
    }
}
