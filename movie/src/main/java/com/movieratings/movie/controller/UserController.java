package com.movieratings.movie.controller;


import com.movieratings.movie.service.UserService;
import com.movieratings.movie.service.request.UserSignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //route for signingup as users/admin
    @PostMapping("/signup")
    public ResponseEntity<Object> addUser(@RequestBody UserSignUpRequest userRequest){
        String result = userService.addUser(userRequest.toMyUser());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
