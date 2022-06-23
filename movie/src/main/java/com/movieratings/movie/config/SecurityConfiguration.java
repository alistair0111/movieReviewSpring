package com.movieratings.movie.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    private static final String ADMIN_AUTH="admin";

    private static final String USER_AUTH="user";

    @Bean
    public PasswordEncoder getMyPasswordEncoder(){
        return  NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/movie/**").hasAuthority(USER_AUTH)
                .antMatchers("/admin/**").hasAuthority(ADMIN_AUTH)
                .antMatchers("/user/signup").permitAll()
                .and().httpBasic();
        return httpSecurity.build();
    }
}
