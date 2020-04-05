package com.java_todo.springbootpgreacttodo.model;

import javax.persistence.*;

@Entity
@Table(name = "to-do-list")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "todo")
    private String todo;

    @Column(name = "completed")
    private Boolean completed;

    public ToDo() {
        super();
    }

    public ToDo(String todo, Boolean completed) {
        this.todo = todo;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return todo;
    }

    public void setTask(String task) {
        this.todo = todo;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
