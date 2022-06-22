package com.movieratings.movie.service;

import com.movieratings.movie.domain.Users;
import com.movieratings.movie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public String addUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(userRepository.findByUsername(user.getUsername())==null){
            userRepository.save(user);
            return "User created";
        }else{
            return "User with username "+user.getUsername()+" already exists";
        }

    }
}
