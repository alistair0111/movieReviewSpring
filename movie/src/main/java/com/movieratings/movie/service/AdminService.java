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
import java.util.*;

@Service
public class AdminService {

    @Autowired
    MovieDBService movieDBService;

    PreparedStatement movieInsertAdminStatement;
    PreparedStatement getMoviesStatement;
    PreparedStatement genreInsertStatement;
    PreparedStatement getGenreStatement;
    PreparedStatement getMovieByGenreStatement;

    String uniqueID;

    Logger log= LoggerFactory.getLogger(AdminService.class);


    @PostConstruct
    public void createPreparedStatements() throws SQLException {
        movieInsertAdminStatement = movieDBService.getSQLConnection().prepareStatement("insert into movies (id, mname, ratings, year, description) values (?,?,?,?,?)");
        genreInsertStatement = movieDBService.getSQLConnection().prepareStatement("insert into genre_table (id, genre) values (?,?)");
        getMoviesStatement = movieDBService.getSQLConnection().prepareStatement("select * from movies");
        getGenreStatement = movieDBService.getSQLConnection().prepareStatement("select genre from genre_table where id=?");
        getMovieByGenreStatement = movieDBService.getSQLConnection().prepareStatement("select * from movies where id in (select id from genre_table where genre=?)");
    }



    public List<Movie> getAllMovies() throws SQLException {
        ResultSet set = getMoviesStatement.executeQuery();
        ArrayList<Movie> mList = new ArrayList<>();
        while(set.next()){
            Movie m= new Movie();
            m.setId(set.getString("id"));
            m.setMname(set.getString("mname"));
            m.setDescription(set.getString("description"));
            m.setRatings(set.getInt("ratings"));
            m.setYear((set.getInt("year")));
            getGenreStatement.setString(1, set.getString("id"));
            ResultSet genreSet = getGenreStatement.executeQuery();
            List<String> tempL = new ArrayList<>();
            while (genreSet.next()){
                tempL.add(genreSet.getString("genre"));
            }
            String[] tempA = new String[tempL.size()];
            tempA = tempL.toArray(tempA);
            m.setGenre(tempA);
            mList.add(m);
        }
        return mList;
    }

    public Movie addMovie(Movie movie) {
        try {
            uniqueID = UUID.randomUUID().toString();
            movieInsertAdminStatement.setString(1, uniqueID);
            movieInsertAdminStatement.setString(2, movie.getMname());
            movieInsertAdminStatement.setInt(3, movie.getRatings());
            movieInsertAdminStatement.setInt(4, movie.getYear());
            movieInsertAdminStatement.setString(5, movie.getDescription());
            movieInsertAdminStatement.execute();

            String genreArray[] = movie.getGenre();
            for(String genre: genreArray){
                genreInsertStatement.setString(1, uniqueID);
                genreInsertStatement.setString(2, genre);
                genreInsertStatement.execute();
            }
        }catch (Exception ex){
            log.error(ex.toString());
        }
        movie.setId(uniqueID);
        return movie;
    }

    public List<Movie> getMovieByGenre(String[] genre) {
        HashSet<Movie> mSet = new HashSet<>();
        try {
            for(String genreVal: genre){
                getMovieByGenreStatement.setString(1, genreVal);
                ResultSet set = getMovieByGenreStatement.executeQuery();
                while (set.next()) {

                    Movie m = new Movie();
                    m.setId(set.getString("id"));
                    m.setMname(set.getString("mname"));
                    m.setDescription(set.getString("description"));
                    m.setRatings(set.getInt("ratings"));
                    m.setYear((set.getInt("year")));
                    mSet.add(m);
                }
            }

            return new ArrayList<>(mSet);
        } catch (Exception ex) {
            log.error(ex.toString());
        }
        return new ArrayList<>(mSet);
    }
}
