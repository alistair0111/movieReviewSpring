package com.movieratings.movie.service;


import com.movieratings.movie.domain.Movie;
import com.movieratings.movie.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private MovieRepository movieRepository;

    public AdminService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie){ return movieRepository.save(movie);}

    public Optional<Movie> getMovie(long movieId){
        return movieRepository.findById(movieId);
    }
}
