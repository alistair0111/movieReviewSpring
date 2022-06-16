package com.movieratings.movie.service.request;

import com.movieratings.movie.domain.Genre;
import com.movieratings.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieUpdateRequest {
    private long id;
    private String title;
    private Genre genre;

    public Movie toMovie(){
        return Movie.builder().title(title).genre(genre).rating(0.0).adminName("localhostAdmin").movieId(id).build();
    }
}
