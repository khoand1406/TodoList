package com.project.DAO.iInterface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.Todo;

public interface TodoInteface extends JpaRepository<Todo, Long> {
    @Query("select t from Todo where t.user.id= :userId")
    public List<Todo> getListByUserId(Long userId);

    @Query("Select t from Todo t where t.category.id = :cateId and t.date= :date")
    List<Todo> getListByFilter(String cateId, java.sql.Date date);

    @Query("Select t from Todo t where t.category.id= :cateid and t.user.id= :userid")
    public List<Todo> getListByCategory(Long userid, Long cateid);

    @Query("Select t from Todo t Join Fetch t.category c where t.user.id= :userid and t.date= :date")
    public List<Todo> getListByFilterDate(Long userid, java.sql.Date date);

    public void updateTodo(Todo todo);

    public void deleteTodo(Todo todo);

    public void saveTodo(Todo todo);
}
