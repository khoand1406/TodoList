package com.project.DAO.iInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Model.Category;

public interface CategoryInterface extends JpaRepository<Category, Long> {

}
