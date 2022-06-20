package com.movieratings.movie.service.request;

import com.movieratings.movie.domain.Genre;
import com.movieratings.movie.domain.GenreTable;
import com.movieratings.movie.domain.Movie;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieUpdateRequest {
    private long id;
    private String title;
    private List<Genre> genres;

    public Movie toMovie(){
        List<GenreTable> genresList = new ArrayList<>();
        Movie movie = Movie.builder().movieId(id).title(title).rating(0.0).adminName("localhostAdmin").build();
        for(Genre g: genres){
            genresList.add(GenreTable.builder().genre(g).movie1(movie).build());
        }
        movie.setGenres(genresList);
        return movie;
    }
}
