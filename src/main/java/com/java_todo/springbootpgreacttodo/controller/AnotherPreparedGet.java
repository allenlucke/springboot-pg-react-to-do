package com.java_todo.springbootpgreacttodo.controller;

import com.java_todo.springbootpgreacttodo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.sql.ResultSet;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")

public class AnotherPreparedGet {

    @Autowired
    private ToDoRepository toDoRepository;
    //    Connection connection = null;
    private static final String HOST = "jdbc:postgresql://localhost:5432/";
    private static final String DB = "to-do-java";
    private static final String USER = "allenlucke";
    private static final String PASSWORD = "";
//    PreparedStatement pstmt = null;

    @GetMapping("to-do-list/anotherPreparedGet")
    public static void Results( ResultSet[] rset )
            throws SQLException
    {
        Connection con = DriverManager.getConnection(
                HOST+DB,USER,PASSWORD );
        Statement stmt = con.createStatement();
        rset[0] =
                stmt.executeQuery (
                        "SELECT * FROM \"to_do_list\"n" );
//        rset1[0] = rset;
    }

}
