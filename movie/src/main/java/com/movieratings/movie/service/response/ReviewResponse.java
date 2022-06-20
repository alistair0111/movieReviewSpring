package com.movieratings.movie.service.response;

import com.movieratings.movie.domain.Review;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponse {
    private long movieId;
    private Review review;
}
