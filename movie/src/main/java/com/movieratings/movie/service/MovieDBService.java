package com.movieratings.movie.service;


import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.*;

@Service
public class MovieDBService {

        Connection mysqlConnection;

    public MovieDBService() throws SQLException {

        mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieDB","root","password");

    }
    public Connection getSQLConnection(){
        return mysqlConnection;
    }

    @PostConstruct
    private void createRequiredTable() throws SQLException {

        Statement statement = mysqlConnection.createStatement();
        // query to create table
        String queryMovieTable = "create table if not exists movies (id varchar(200) primary key, mname varchar(20), ratings int, year int, description varchar(250))";

        // statement to execute
        statement.execute(queryMovieTable);

        String genreTable = "create table if not exists genre_table (id varchar(200) , genre varchar(200), FOREIGN KEY (id) REFERENCES movies(id))";

        statement.execute(genreTable);
    }

}
