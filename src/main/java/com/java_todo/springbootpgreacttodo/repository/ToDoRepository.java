package com.java_todo.springbootpgreacttodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java_todo.springbootpgreacttodo.model.ToDo;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
