package com.hyberlet.task_23.model.security;

import com.hyberlet.task_23.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class AppUserDetails implements UserDetails {
    private AppUser appUser;
    private final List<GrantedAuthority> grantedAuthorities = new ArrayList<>();



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return appUser.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
