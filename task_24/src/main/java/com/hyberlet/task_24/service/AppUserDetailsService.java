package com.hyberlet.task_24.service;

import com.hyberlet.task_24.model.AppUser;
import com.hyberlet.task_24.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findAppUserByLogin(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("Username: %s not found", username))
        );
        return new User(user.getLogin(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }
}
