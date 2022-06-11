package com.movieratings.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String id;

    private String mname;

    private String[] genre;

    @Min(value=1,message = "rating should greater than 0")
    @Max(value=5,message = "rating should less than or equal to 5")
    private int ratings = 1;
    @Min(value=1800,message = "year should be greater than 1800")
    @Max(value=2022,message = "year should be less than 2022")
    private int year;
    private String description;
}
