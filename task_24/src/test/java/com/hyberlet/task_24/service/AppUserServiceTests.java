package com.hyberlet.task_24.service;

import com.hyberlet.task_24.config.SecurityConfiguration;
import com.hyberlet.task_24.model.AppUser;
import com.hyberlet.task_24.repository.AppUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@ExtendWith(MockitoExtension.class)
public class AppUserServiceTests {

    @Mock
    private AppUserRepository appUserRepository;

    @Mock
    private PasswordEncoder encoder;

    @InjectMocks
    private AppUserService appUserService;

    @PostConstruct
    public void setEncoder() {

    }

    @Test
    public void create() {

        Mockito.when(encoder.encode("admin")).thenReturn("$2a$10$lb.fBytxRRqUGNl0YOhideSJqFphce0L.DhHtryer9Q3WQgDoOdeS");

        AppUser appUser = new AppUser();
        appUser.setLogin("admin");
        appUser.setPassword(encoder.encode("admin"));

        Mockito.when(appUserRepository.save(appUser)).thenReturn(appUser);

        AppUser admin = new AppUser();
        admin.setLogin("admin");
        admin.setPassword("admin");
        AppUser adminEncoded = appUserService.create(admin);
        Mockito.verify(appUserRepository).save(adminEncoded);
        Assertions.assertEquals(appUser, adminEncoded);
    }

}
