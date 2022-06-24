package com.movieratings.movie.service.request;


import com.movieratings.movie.domain.Genre;
import com.movieratings.movie.domain.GenreTable;
import com.movieratings.movie.domain.Movie;
import lombok.*;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieAddRequest {

    private String title;
    private List<Genre> genres;

    public Movie toMovie(){
        List<GenreTable> genresList = new ArrayList<>();
        String adminName = SecurityContextHolder.getContext().getAuthentication().getName();
        Movie movie = Movie.builder().title(title).rating(0.0).adminName(adminName).build();
        for(Genre g: genres){
            genresList.add(GenreTable.builder().genre(g).movie1(movie).build());
        }
        movie.setGenres(genresList);
        return movie;
    }


}
