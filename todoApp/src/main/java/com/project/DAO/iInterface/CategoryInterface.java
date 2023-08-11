package com.project.DAO.iInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.Category;

public interface CategoryInterface extends JpaRepository<Category, Long> {
    @Query("Select * from Category c where c.id= :id")
    public Category getOne(Long id);
}
