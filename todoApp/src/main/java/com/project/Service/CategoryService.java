package com.project.Service;

import java.util.List;
import java.util.Optional;

import com.project.Model.Category;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(Long id);

}
