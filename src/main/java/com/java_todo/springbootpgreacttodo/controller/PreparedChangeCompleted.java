package com.java_todo.springbootpgreacttodo.controller;
import com.java_todo.springbootpgreacttodo.repository.ToDoRepository;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1")
public class PreparedChangeCompleted {

    @Autowired
    private ToDoRepository toDoRepository;
//    Connection connection = null;
    private static final String HOST = "jdbc:postgresql://localhost:5432/";
    private static final String DB = "to-do-java";
    private static final String USER = "allenlucke";
    private static final String PASSWORD = "";
//    PreparedStatement pstmt = null;

    @PutMapping("to-do-list/preparedPut")
    public static void main(String[] args) {
        String sqlQuery = "UPDATE \"to_do_list\" SET \"completed\" = TRUE\n" +
                "WHERE \"id\" = 3;";

        try {
//            Class.forName("com.postgresql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(HOST+DB,USER,PASSWORD);

            PreparedStatement preparedSelect = conn.prepareStatement(sqlQuery);
            ResultSet rs = preparedSelect.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/to-do-java", "allenlucke", "root");