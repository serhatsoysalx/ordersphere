package com.ordersphere.ordersphere.model.custom;

import com.ordersphere.ordersphere.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails extends User implements UserDetails {

    private final UserModel userModel;

    public CustomUserDetails(UserModel userModel) {
        super(userModel.getUsername(), userModel.getPasswordHash(), userModel.getUserRules().stream()
                .map(rule -> new SimpleGrantedAuthority(rule.getRuleName()))
                .collect(Collectors.toList()));
        this.userModel = userModel;
    }

    @Override
    public String getUsername() {
        return userModel.getUsername();
    }

    @Override
    public String getPassword() {
        return userModel.getPasswordHash();
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

    public UserModel getUserModel() {
        return userModel;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return userModel.getUserRules().stream()
                .map(rule -> new SimpleGrantedAuthority(rule.getRuleName()))
                .collect(Collectors.toSet());
    }
}
