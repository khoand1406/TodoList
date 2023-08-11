package com.project.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.project.Model.Todo;

public interface TodoService {
    public List<Todo> getListByUserId(Long id);

    public Optional<Todo> geTodoById(Long id);

    public List<Todo> getListByFilter(String cateId, Date date);

    public List<Todo> getListByCategory(Long userid, Long id);

}