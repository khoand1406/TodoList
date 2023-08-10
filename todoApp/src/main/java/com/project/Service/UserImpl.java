package com.project.Service;

import com.project.Model.User;

public class UserImpl implements UserDetailsService {

    private final UserService userService;

    public UserImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void Signin(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Signin'");
    }

    @Override
    public User getUser(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
