package com.movieratings.movie.service.request;

import com.movieratings.movie.domain.Movie;
import com.movieratings.movie.domain.Review;
import com.movieratings.movie.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {

    private String movieReview;

    private double rating;

    private Long movieId;

    private int userId;

    public Review toReview(){
        return Review.builder()
                .movieReview(movieReview)
                .rating(rating)
                .movie(Movie.builder()
                        .movieId(movieId)
                        .build())
                .users(Users.builder().
                        userId(userId)
                        .build())
                .build();

    }
}
