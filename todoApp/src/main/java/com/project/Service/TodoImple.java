package com.project.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.project.DAO.iInterface.CategoryInterface;
import com.project.DAO.iInterface.TodoInteface;
import com.project.DAO.iInterface.UserInterface;
import com.project.Model.Category;
import com.project.Model.Todo;
import com.project.Model.User;

public class TodoImple implements TodoService {

    private TodoInteface todoRepo;
    private CategoryInterface cateRepo;
    private UserInterface userRepo;

    @Override
    public List<Todo> getListByFilter(String cateId, Date date) {
        return todoRepo.getListByFilter(cateId, date);
    }

    @Override
    public List<Todo> getListByUserId(Long userId) {
        return todoRepo.getListByUserId(userId);
    }

    @Override
    public List<Todo> getListByCategory(Long userid, Long cateid) {
        return todoRepo.getListByCategory(userid, cateid);
    }

    @Override
    public Optional<Todo> geTodoById(Long id) {
        return todoRepo.findById(id);
    }

    public void addTodo(Long userid, String title, String description, Date date, boolean isDone, Long cate) {
        User user = userRepo.get(userid);
        Category category = cateRepo.getOne(cate);
        Todo todo = new Todo();
        todo.setUser(user);
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setDate(date);
        todo.setCategory(category);
        todoRepo.save(todo);
    }

    public void save(Todo todo) {
        todoRepo.save(todo);
    }

    public void updateTodo(Todo todo) {
        todoRepo.save(todo);
    }

    public void deleteTodo(Todo todo) {
        todoRepo.delete(todo);
    }
}
