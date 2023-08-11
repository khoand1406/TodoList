package com.project.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.Model.User;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}
