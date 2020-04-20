

package com.java_todo.springbootpgreacttodo.controller;
import com.java_todo.springbootpgreacttodo.exception.ResourceNotFoundException;
import com.java_todo.springbootpgreacttodo.model.ToDo;
import com.java_todo.springbootpgreacttodo.repository.ToDoRepository;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
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
    private static final String HOST = "jdbc:postgresql://localhost:5432/";
    private static final String DB = "to-do-java";
    private static final String USER = "allenlucke";
    private static final String PASSWORD = "";
    // get to-dos
    @GetMapping("to-do-list")
    public List<ToDo> getAllToDo() {
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
                                           @Valid @RequestBody ToDo toDoDetails) throws ResourceNotFoundException {
        ToDo toDo = toDoRepository.findById(toDoId)
                .orElseThrow(() -> new ResourceNotFoundException("To Do not found for this id :: " + toDoId));

        toDo.setTask(toDoDetails.getTask());
        toDo.setCompleted(toDoDetails.getCompleted());
        toDo.setAssigned_on(toDoDetails.getAssigned_on());

        return ResponseEntity.ok(this.toDoRepository.save(toDo));
    }

    // delete to-do
    @DeleteMapping("to-do-list/{id}")
    public Map<String, Boolean> deleteToDo(@PathVariable(value = "id") Long toDoId) throws ResourceNotFoundException {
        ToDo toDo = toDoRepository.findById(toDoId)
                .orElseThrow(() -> new ResourceNotFoundException("To Do not found for this id :: " + toDoId));

        this.toDoRepository.delete(toDo);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

    @GetMapping("to-do-list/new/{id}")
    public List<ToDo> getToDo(@PathVariable(value = "id") long toDoId) {
        String sqlQuery = "SELECT * FROM to_do_list WHERE id = ?";
        List<ToDo> getToDo = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(HOST+DB,USER,PASSWORD);
             PreparedStatement ps = con.prepareStatement(sqlQuery);) {
            ps.setLong(1, toDoId);
            try (ResultSet rs = ps.executeQuery();) {
                while(rs.next()) {
//                    long id = rs.getLong(1);
//                    String task = rs.getString(2);
//
//                    System.out.printf("%d\t%s\n", id, task);
                    getToDo.add(new ToDo(rs.getLong("id"), rs.getString("task"), rs.getBoolean("completed"),
                            rs.getTimestamp("assigned_on"), rs.getTimestamp("due_by"), rs.getTimestamp("when_completed")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getToDo;
    }

    @PutMapping("to-do-list/putTorF/{id}")
    public List<ToDo> putToDo(@PathVariable(value ="id") long toDoId) {
        String sqlQuery = "UPDATE \"to_do_list\" SET \"completed\" = NOT \"completed\" WHERE id = ?\n" +
                "returning * ;";
        List<ToDo> putToDo = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(HOST + DB, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sqlQuery);) {
            ps.setLong(1, toDoId);
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    putToDo.add(new ToDo(rs.getLong("id"), rs.getString("task"), rs.getBoolean("completed"),
                            rs.getTimestamp("assigned_on"), rs.getTimestamp("due_by"), rs.getTimestamp("when_completed")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return putToDo;
    }
}
