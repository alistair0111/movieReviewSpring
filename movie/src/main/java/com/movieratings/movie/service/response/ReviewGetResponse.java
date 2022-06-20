package com.movieratings.movie.service.response;

import com.movieratings.movie.domain.Movie;
import com.movieratings.movie.domain.Review;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewGetResponse {
    private long movieId;
    private Review review;
    private Movie movie;
}
