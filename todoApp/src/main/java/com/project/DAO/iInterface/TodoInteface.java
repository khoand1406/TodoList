package com.project.DAO.iInterface;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.project.Model.Todo;

public interface TodoInteface {
    public List<Todo> getListByUserId(int id);

    @Query("Select t from Todo t where t.category.id = :cateId and t.date= :date")
    List<Todo> getListByFilter(String cateId, java.sql.Date date);

    public void deleteTodo(Todo todo);

}
