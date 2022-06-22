package com.movieratings.movie.config;

import com.movieratings.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthorityProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String userpassword = authentication.getCredentials().toString();
        UserDetails myDbUser = userService.loadUserByUsername(username);
        if(myDbUser!=null && passwordEncoder.matches(userpassword, myDbUser.getPassword()))
            return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), myDbUser.getAuthorities());
        throw new BadCredentialsException("Invalid Credentials");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
