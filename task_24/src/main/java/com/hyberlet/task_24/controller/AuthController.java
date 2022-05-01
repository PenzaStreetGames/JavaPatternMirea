package com.hyberlet.task_24.controller;

import com.hyberlet.task_24.model.AppUser;
import com.hyberlet.task_24.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AppUserService appUserService;

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
