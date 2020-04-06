

package com.java_todo.springbootpgreacttodo.controller;
import com.java_todo.springbootpgreacttodo.exception.ResourceNotFoundException;
import com.java_todo.springbootpgreacttodo.model.ToDo;
import com.java_todo.springbootpgreacttodo.repository.ToDoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
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


    // save to-do
    @PostMapping("to-do-list")
    public ToDo createToDo(@RequestBody ToDo toDo) {
        toDo.setCompleted(false);
        return this.toDoRepository.save(toDo);
    }

    // update to-do
    @PutMapping("to-do-list/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable(value = "id") Long toDoId,
                                           @Valid @RequestBody ToDo toDoDetails) throws ResourceNotFoundException{
        ToDo toDo = toDoRepository.findById(toDoId)
                .orElseThrow(() -> new ResourceNotFoundException("To Do not found for this id :: " + toDoId));

        toDo.setTask(toDoDetails.getTask());
        toDo.setCompleted(toDoDetails.getCompleted());

        return ResponseEntity.ok(this.toDoRepository.save(toDo));
    }

    // delete to-do
    @DeleteMapping("to-do-list/{id}")
    public Map<String, Boolean> deleteToDo(@PathVariable(value = "id") Long toDoId) throws ResourceNotFoundException{
        ToDo toDo = toDoRepository.findById(toDoId)
                .orElseThrow(() -> new ResourceNotFoundException("To Do not found for this id :: " + toDoId));

        this.toDoRepository.delete(toDo);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

}
