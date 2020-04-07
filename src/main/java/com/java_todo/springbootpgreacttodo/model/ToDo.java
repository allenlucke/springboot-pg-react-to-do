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

    @Column(name = "assignedOn")
    private String assignedOn;

    @Column(name = "dueBy")
    private String dueBy;

    @Column(name = "whenCompleted")
    private String whenCompleted;

    public ToDo() {
        super();
    }

    public ToDo(long id, String task, Boolean completed, String assignedOn, String dueBy, String whenCompleted) {
        this.id = id;
        this.task = task;
        this.completed = completed;
        this.assignedOn = assignedOn;
        this.dueBy = dueBy;
        this.whenCompleted = whenCompleted;
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

    public String getAssignedOn() {
        return assignedOn;
    }

    public void setAssignedOn(String assignedOn) {
        this.assignedOn = assignedOn;
    }

    public String getDueBy() {
        return dueBy;
    }

    public void setDueBy(String dueBy) {
        this.dueBy = dueBy;
    }

    public String getWhenCompleted() {
        return whenCompleted;
    }

    public void setWhenCompleted(String whenCompleted) {
        this.whenCompleted = whenCompleted;
    }
}
