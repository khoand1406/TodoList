package com.project.DAO.iInterface;

import java.sql.Date;
import java.util.List;

import com.project.Model.Todo;

public interface TodoInteface {
    public List<Todo> getListByUserId(int id);

    public Todo getTodoById(int id);

    public List<Todo> getListByCategory(int id);

    public List<Todo> getListByFilterDate(Date date);

    public void saveTodo(Todo todo);

    public void updateTodo(Todo todo);

    public void deleteTodo(Todo todo);

}
