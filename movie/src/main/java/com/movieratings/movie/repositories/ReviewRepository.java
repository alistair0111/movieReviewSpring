package com.movieratings.movie.repositories;


import com.movieratings.movie.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
