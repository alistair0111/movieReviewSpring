package com.movieratings.movie.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.movieratings.movie.service.response.MovieResponse;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private List<Review> reviewList;

    public MovieResponse toMovieResponse(){
        return MovieResponse.builder().genre(this.genre).title(this.title).rating(this.rating).build();
    }

}
