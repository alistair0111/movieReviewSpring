package com.movieratings.movie.service.response;


import com.movieratings.movie.domain.GenreTable;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponse {

    private String title;
    private List<GenreTable> genres;
    private Double rating;

}
