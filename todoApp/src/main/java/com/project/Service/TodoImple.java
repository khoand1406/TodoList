package com.project.Service;

import java.sql.Date;
import java.util.List;

import com.project.DAO.iInterface.TodoInteface;
import com.project.Model.Todo;

public class TodoImple implements TodoInteface {

    @Override
    public List<Todo> getListByUserId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListByUserId'");
    }

    @Override
    public List<Todo> getListByCategory(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListByCategory'");
    }

    @Override
    public List<Todo> getListByFilterDate(Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListByFilterDate'");
    }

    @Override
    public void saveTodo(Todo todo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveTodo'");
    }

    @Override
    public void updateTodo(Todo todo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTodo'");
    }

    @Override
    public void deleteTodo(Todo todo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTodo'");
    }

    @Override
    public List<Todo> getListByFilter(String cateId, Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListByFilter'");
    }

}
