package com.movieratings.movie.service.request;

import com.movieratings.movie.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequest {

    private String username;

    private String password;

    private String authorities="user";

    public Users toMyUser(){
        return Users.builder().username(username).password(password).authorities(authorities).build();
    }

}
