package com.project.DAO.iInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Model.User;

public interface UserInterface extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
