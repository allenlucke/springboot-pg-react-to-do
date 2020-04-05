package com.java_todo.springbootpgreacttodo.controller;

import java.util.List;

import com.java_todo.springbootpgreacttodo.exception.ResourceNotFoundException;
import com.java_todo.springbootpgreacttodo.model.ToDo;
import com.java_todo.springbootpgreacttodo.repository.ToDoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    // get to-dos
    @GetMapping("to-do-list")
    public List<ToDo> getAllToDo(){
        return this.toDoRepository.findAll();
    }

    // get to-do by id
    @GetMapping("to-do-list/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable(value = "id") Long toDoId)
            throws ResourceNotFoundException {
        ToDo toDo = toDoRepository.findById(toDoId)
                .orElseThrow(() -> new ResourceNotFoundException("To Do not found for this id :: " + toDoId));
        return ResponseEntity.ok().body(toDo);
    }

    // save to-do
    @PostMapping("to-do-list")
    public ToDo createToDo(@RequestBody ToDo toDo) {
        return this.toDoRepository.save(toDo);
    }

    // update to-do
    // delete to-do

}
