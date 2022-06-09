package com.movieratings.movie.controllers;

import com.movieratings.movie.domain.Movie;
import com.movieratings.movie.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/getMovies")
    public ResponseEntity<List<Movie>> getAllMovies() throws SQLException {
        return new ResponseEntity<>(adminService.getAllMovies(), HttpStatus.OK);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<Movie> addMovie(@RequestBody @Valid Movie movie) throws SQLException {
        return new ResponseEntity<>(adminService.addMovie(movie), HttpStatus.CREATED);
    }
}
