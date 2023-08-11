package com.project.DAO.iInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Model.SubTodo;

public interface SubTodoInterface extends JpaRepository<SubTodo, Long> {
    public SubTodo get(Long id);

    public SubTodo getByTodo(Long id);

    public void addSubTodo(SubTodo sub);

    public void updateSub(SubTodo sub);

    public void deleteSub(SubTodo sub);
}
