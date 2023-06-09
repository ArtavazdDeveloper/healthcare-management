package com.example.healthcaremanagementhealthcaremanagement.security;

import com.example.healthcaremanagementhealthcaremanagement.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User{
    private User user;
    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getName()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
