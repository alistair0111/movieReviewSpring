package com.movieratings.movie.service;


import com.movieratings.movie.domain.Movie;
import com.movieratings.movie.repositories.MovieRepository;
import org.springframework.stereotype.Service;

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
}
