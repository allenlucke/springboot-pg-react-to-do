package com.java_todo.springbootpgreacttodo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "to_do_list")
public class ToDo {

    public ToDo() {
        super();
    }

    public ToDo(long id, String task, Boolean completed, Timestamp assigned_on, Timestamp due_by, Timestamp when_completed) {
        this.id = id;
        this.task = task;
        this.completed = completed;
        this.assigned_on = assigned_on;
        this.due_by = due_by;
        this.when_completed = when_completed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "task")
    private String task;

    @Column(name = "completed")
    private Boolean completed;

    @Column(name = "assigned_on")
    private Timestamp assigned_on;

    @Column(name = "due_by")
    private Timestamp due_by;

    @Column(name = "when_completed")
    private Timestamp when_completed;


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

    public Timestamp getAssigned_on() {
        return assigned_on;
    }

    public void setAssigned_on(Timestamp assigned_on) {
        this.assigned_on = assigned_on;
    }

    public Timestamp getDue_by() {
        return due_by;
    }

    public void setDue_by(Timestamp due_by) {
        this.due_by = due_by;
    }

    public Timestamp getWhen_completed() {
        return when_completed;
    }

    public void setWhen_completed(Timestamp when_completed) {
        this.when_completed = when_completed;
    }








}
