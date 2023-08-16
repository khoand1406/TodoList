package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.DAO.iInterface.UserInterface;
import com.project.Model.User;

public class UserImpl implements UserDetailsService {
    @Autowired
    private final UserService userService;
    @Autowired
    private final UserInterface userRepo;

    public UserImpl(UserService userService, UserInterface userRe) {
        this.userService = userService;
        this.userRepo = userRe;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }

    public User getAuthenticated(String username, String password) {
        return userRepo.getAuthUser(username, password);
    }

    public void getNewAuthen(User user) {
        userRepo.save(user);
    }

    public User findByEmail(String email) {
        User usercheck = userRepo.findByEmail(email);
        return usercheck;
    }
}
