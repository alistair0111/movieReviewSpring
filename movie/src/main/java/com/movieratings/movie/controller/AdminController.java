package com.movieratings.movie.controller;



import com.movieratings.movie.domain.Movie;
import com.movieratings.movie.service.AdminService;
import com.movieratings.movie.service.request.MovieAddRequest;
import com.movieratings.movie.service.request.MovieUpdateRequest;
import com.movieratings.movie.service.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/movie/add")
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieAddRequest movieRequest){
        return new ResponseEntity<>(adminService.addMovie(movieRequest.toMovie()).toMovieResponse(), HttpStatus.CREATED);
    }

    @PutMapping("/movie/update")
    public ResponseEntity<MovieResponse> updateMovie(@RequestBody MovieUpdateRequest movieUpdateRequest){
        return new ResponseEntity<>(adminService.updateMovie(movieUpdateRequest.toMovie()).toMovieResponse(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/movie/get")
    public ResponseEntity<Object> getMovie(@RequestParam Long movieId) {
        Optional<Movie> movie = adminService.getMovie(movieId);
        return new ResponseEntity<>(movie.isPresent()?movie.get():"Could not find movie with Id: " + movieId, HttpStatus.OK) ;
    }
}




















