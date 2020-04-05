package com.java_todo.springbootpgreacttodo.model;

import javax.persistence.*;

@Entity
@Table(name = "to_do_list")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "task")
    private String task;

    @Column(name = "completed")
    private Boolean completed;

    public ToDo() {
        super();
    }

    public ToDo(String task, Boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
