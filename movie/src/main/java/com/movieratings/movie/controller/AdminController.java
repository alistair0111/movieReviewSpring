package com.movieratings.movie.controller;



import com.movieratings.movie.domain.Movie;
import com.movieratings.movie.service.AdminService;
import com.movieratings.movie.service.request.MovieAddRequest;
import com.movieratings.movie.service.request.MovieUpdateRequest;
import com.movieratings.movie.service.response.MovieResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {


    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;


    //route to add movies (admin privileges)
    @PostMapping("/movie_add")
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieAddRequest movieRequest){
        return new ResponseEntity<>(adminService.addMovie(movieRequest.toMovie()).toMovieResponse(), HttpStatus.CREATED);
    }

    //route to update movies (admin privileges)
    @PutMapping("/movie_update")
    public ResponseEntity<MovieResponse> updateMovie(@RequestBody MovieUpdateRequest movieUpdateRequest){
        return new ResponseEntity<>(adminService.updateMovie(movieUpdateRequest.toMovie()).toMovieResponse(), HttpStatus.ACCEPTED);
    }

    //route to get movie by ID (admin privileges)
    @GetMapping("/movie_get")
    public ResponseEntity<Object> getMovie(@RequestParam Long movieId){
        Optional<Movie> movie = adminService.getMovie(movieId);
        return new ResponseEntity<>(movie.isPresent()?movie.get():"Could not find movie with Id: " + movieId, HttpStatus.OK);
    }

    @DeleteMapping("movie_delete")
    public ResponseEntity<Object> deleteMovie(@RequestParam Long movieId){
        try{
            adminService.deleteMovie(movieId);
            return new ResponseEntity<>("Movie with ID "+movieId+" Deleted Successfully", HttpStatus.OK);
        }catch (Exception ex) {
            logger.info(String.format("Error while deleting %1$s",ex));
            return new ResponseEntity<>("Movie with ID " + movieId + " could not be deleted", HttpStatus.OK);
        }
    }
}




















