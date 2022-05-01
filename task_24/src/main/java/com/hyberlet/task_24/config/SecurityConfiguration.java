package com.hyberlet.task_24.config;

import com.hyberlet.task_24.controller.security.AuthFailureHandler;
import com.hyberlet.task_24.controller.security.AuthSuccessHandler;
import com.hyberlet.task_24.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserDetailsService appUserDetailsService;
    @Autowired
    private AuthFailureHandler authFailureHandler;
    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/login", "/logout", "/registration")
                .permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .failureHandler(authFailureHandler)
                .successHandler(authSuccessHandler)
                .and().rememberMe()
                .tokenValiditySeconds((int) TimeUnit.MINUTES.toSeconds(5))
                .and().userDetailsService(appUserDetailsService)
                .sessionManagement();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(appUserDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailsService);
        auth.authenticationProvider(authProvider());
    }
}
