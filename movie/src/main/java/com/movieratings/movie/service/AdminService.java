package com.movieratings.movie.service;

import com.movieratings.movie.domain.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    MovieDBService movieDBService;

    PreparedStatement movieInsertAdminStatement;
    PreparedStatement getMoviesStatement;

    Logger log= LoggerFactory.getLogger(AdminService.class);


    @PostConstruct
    public void createPreparedStatements() throws SQLException {
        movieInsertAdminStatement = movieDBService.getSQLConnection().prepareStatement("insert into movies (mname, genre, ratings, year, description) values (?,?,?,?,?)");
        getMoviesStatement = movieDBService.getSQLConnection().prepareStatement("select * from movies");
    }

    public List<Movie> getAllMovies() throws SQLException {
        ResultSet set = getMoviesStatement.executeQuery();
        ArrayList<Movie> mList = new ArrayList<>();
        while(set.next()){
            Movie m= new Movie();
            m.setId(set.getInt("id"));
            m.setMname(set.getString("mname"));
            m.setDescription(set.getString("description"));
            m.setGenre(set.getString("genre"));
            m.setRatings(set.getInt("ratings"));
            m.setYear((set.getInt("year")));
            mList.add(m);
        }
        return mList;
    }

    public Movie addMovie(Movie movie) {
        try {
            movieInsertAdminStatement.setString(1, movie.getMname());
            movieInsertAdminStatement.setString(2, movie.getGenre());
            movieInsertAdminStatement.setInt(3, movie.getRatings());
            movieInsertAdminStatement.setInt(4, movie.getYear());
            movieInsertAdminStatement.setString(5, movie.getDescription());
            movieInsertAdminStatement.execute();
        }catch (Exception ex){
            log.error(ex.toString());
        }
        return movie;
    }
}
