package com.movieratings.movie.service;


import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.*;

@Service
public class MovieDBService {

    Connection mysqlConnection;

    public MovieDBService() throws SQLException {

        mysqlConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/movieDB","root","password");

    }
    public Connection getSQLConnection(){
        return mysqlConnection;
    }

    @PostConstruct
    private void createRequiredTable() throws SQLException {

        Statement statement = mysqlConnection.createStatement();
        // query to create table
        String query = "create table if not exists movies (id int primary key auto_increment, mname varchar(20), genre varchar(50), ratings int, year int, description varchar(250))";

        // statement to execute
        statement.execute(query);
    }

}
