package com.project.Service;

import java.util.List;

import com.project.Model.SubTodo;

public interface SubTodoService {
    public SubTodo get(Long id);

    public List<SubTodo> getByTodo(Long id);

    public void addSubTodo(SubTodo sub);

    public void updateSub(SubTodo sub);

    public void deleteSub(SubTodo sub);
}
