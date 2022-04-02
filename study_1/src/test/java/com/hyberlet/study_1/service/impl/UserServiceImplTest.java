package com.hyberlet.study_1.service.impl;

import com.hyberlet.study_1.model.User;
import com.hyberlet.study_1.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void testCreate() {
        User user = new User();
        user.setPassword("Qwerty123!");
        String encodedPassword = "jf2w0jisdlfnweijdf0qjiedsolkfmwepofdjmsd";
        Mockito.doReturn(encodedPassword)
                .when(passwordEncoder).encode(user.getPassword());
        userService.add(user);
        Mockito.verify(userRepository).save(user);
        Assertions.assertEquals(encodedPassword, user.getPassword());
    }

}
