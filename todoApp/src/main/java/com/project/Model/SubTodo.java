package com.project.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sub_Todo")

public class SubTodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subid")

    private Long subid;

    @ManyToOne
    @JoinColumn(name = "id")

    private Todo todo;

    @Column(name = "content")
    private String content;

    @Column(name = "subtitle")
    private String subtitle;

    /**
     * @return Long return the subid
     */
    public Long getSubid() {
        return subid;
    }

    /**
     * @param subid the subid to set
     */
    public void setSubid(Long subid) {
        this.subid = subid;
    }

    /**
     * @return Todo return the todo
     */
    public Todo getTodo() {
        return todo;
    }

    /**
     * @param todo the todo to set
     */
    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    /**
     * @return String return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return String return the subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * @param subtitle the subtitle to set
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

}
