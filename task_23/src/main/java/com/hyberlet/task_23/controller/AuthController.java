package com.hyberlet.task_23.controller;

import com.hyberlet.task_23.model.AppUser;
import com.hyberlet.task_23.service.AppUserDetailsService;
import com.hyberlet.task_23.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @PostMapping("/registration")
    public String signUp(@RequestBody AppUser appUser) {
        AppUser user = appUserService.findByUsername(appUser.getLogin());
        if (user != null) {
            return String.format("user with name %s already exists", user.getLogin());
        }
        appUserService.create(appUser);
        return "ok";
    }

}
