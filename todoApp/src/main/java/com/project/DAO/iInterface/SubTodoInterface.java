package com.project.DAO.iInterface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.SubTodo;

public interface SubTodoInterface extends JpaRepository<SubTodo, Long> {
    public SubTodo get(Long id);

    @Query("Select s from subTodo where s.todo.id= :id ")
    public List<SubTodo> getByTodo(Long id);

    public void addSubTodo(SubTodo sub);

    public void updateSub(SubTodo sub);

    public void deleteSub(SubTodo sub);

    @Query("Update Subtodo s SET s.title =:title, s.description= :description where s.subid= :id ")
    public void updateSub(Long id, SubTodo sub);
}
