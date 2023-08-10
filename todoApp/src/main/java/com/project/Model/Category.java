package com.project.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @Column(name = "CategoryID")

    private Long categoryid;

    @Column(name = "CategoryName")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Todo> todos;

    /**
     * @return Long return the categoryid
     */
    public Long getCategoryid() {
        return categoryid;
    }

    /**
     * @param categoryid the categoryid to set
     */
    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * @return String return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
        todo.setCategory(this);
    }

    public void removeTodo(Todo todo) {
        todos.remove(todo);
        todo.setCategory(null);
    }

}
