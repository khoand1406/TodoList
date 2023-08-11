package com.project.DAO.iInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.User;

public interface UserInterface extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("Select t from User t where t.userid= :userid")
    User get(Long userid);
}
