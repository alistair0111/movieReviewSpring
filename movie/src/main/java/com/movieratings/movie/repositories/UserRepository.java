package com.movieratings.movie.repositories;

import com.movieratings.movie.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}
