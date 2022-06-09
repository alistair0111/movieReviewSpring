package com.movieratings.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MovieRatingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingsApplication.class, args);
	}

}
