package com.hyberlet.task_24.service;

import com.hyberlet.task_24.model.AppUser;
import com.hyberlet.task_24.repository.AppUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUser create(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    public AppUser findByUsername(String username) {
        Optional<AppUser> appUser = appUserRepository.findAppUserByLogin(username);
        if (appUser.isEmpty()) {
            return null;
        }
        return appUser.get();
    }

    public AppUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        return appUserRepository.findAppUserByLogin(principal.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
    }
}
