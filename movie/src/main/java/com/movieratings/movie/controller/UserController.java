package com.movieratings.movie.controller;


import com.movieratings.movie.domain.Movie;
import com.movieratings.movie.domain.Review;
import com.movieratings.movie.service.MovieService;
import com.movieratings.movie.service.ReviewService;
import com.movieratings.movie.service.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    MovieService movieService;

    //route to add movie reviews (user privileges)
    @PostMapping("/review/add")
    public ResponseEntity<Review> addReview(@RequestBody ReviewRequest reviewRequest){
        return new ResponseEntity<>(reviewService.addReview(reviewRequest.toReview()),
                HttpStatus.CREATED);
    }

    //route to find movie reviews by Id (user privileges)
    @GetMapping("/review/find")
    public ResponseEntity<Object> getReview(@RequestParam Long reviewId){
        Review review = reviewService.getReviewById(reviewId);
        return review==null?
            new ResponseEntity<>("The movie with Id: "+reviewId+" Does not exist.",HttpStatus.NOT_FOUND ):
            new ResponseEntity<>(review.toReviewGetResponse(),HttpStatus.OK );
    }


    //route to search movie by title (user privileges)
    @GetMapping("/movie/find")
    public ResponseEntity<Object> getMovie(@RequestParam String movieName ){
        List<Movie> movie = movieService.findMovie(movieName);
        return new ResponseEntity<>(movie==null?"No movie found":movie, HttpStatus.OK);
    }

    //route to search movie by ratings (user privileges)
    @GetMapping("/movie/findbyrating")
    public ResponseEntity<Object> getMovieByRating(@RequestParam double rating ){
        List<Object> movies = movieService.findMovieByRating(rating);
        return new ResponseEntity<>(movies==null?"No movie found":movies, HttpStatus.OK);
    }
}
