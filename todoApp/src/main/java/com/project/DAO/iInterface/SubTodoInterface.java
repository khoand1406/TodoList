package com.project.DAO.iInterface;

import com.project.Model.SubTodo;

public interface SubTodoInterface {
    public SubTodoInterface get(int id);

    public SubTodoInterface getByTodo(int id);

    public void addSubTodo(SubTodo sub);

    public void updateSub(SubTodo sub);

    public void deleteSub(SubTodo sub);
}
