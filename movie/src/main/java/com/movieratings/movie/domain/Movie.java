package com.movieratings.movie.domain;


import com.movieratings.movie.service.response.MovieResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="movie_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Double rating;

    private String adminName;


    public MovieResponse toMovieResponse(){
        return MovieResponse.builder().genre(this.genre).title(this.title).rating(this.rating).build();
    }

}
