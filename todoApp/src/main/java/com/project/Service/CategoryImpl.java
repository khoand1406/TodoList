
package com.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.Model.Category;

@Service

public class CategoryImpl implements CategoryService {

    private final CategoryService categoryRepo;

    public CategoryImpl(CategoryService categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        // TODO Auto-generated method stub
        return categoryRepo.findById(id);
    }

}