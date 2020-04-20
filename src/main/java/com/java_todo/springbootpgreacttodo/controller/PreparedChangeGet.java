package com.java_todo.springbootpgreacttodo.controller;

import com.java_todo.springbootpgreacttodo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class PreparedChangeGet {

    @Autowired
    private ToDoRepository toDoRepository;
    private static final String HOST = "jdbc:postgresql://localhost:5432/";
    private static final String DB = "to-do-java";
    private static final String USER = "allenlucke";
    private static final String PASSWORD = "";

    @GetMapping("to-do-list/preparedGet/{id}")
    public static void main(String[] args, @PathVariable(value = "id") Long toDoId) {
        String sqlQuery = "SELECT * FROM \"to_do_list\"\n" +
                "WHERE \"id\" = 3;";

        try {
//            Class.forName("com.postgresql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(HOST+DB,USER,PASSWORD);

            PreparedStatement preparedSelect = conn.prepareStatement(sqlQuery);
            ResultSet rs = preparedSelect.executeQuery();


//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String task = rs.getString(2);
//                System.out.printf("%d\t%s\n", id, task);
//
//            }

        }
            catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

//    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/to-do-java", "allenlucke", "root");