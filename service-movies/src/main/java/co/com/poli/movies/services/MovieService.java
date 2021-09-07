package co.com.poli.movies.services;

import co.com.poli.movies.entities.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();
    void save(Movie movie);
    Movie findByID(Long numberId);
    void delete(Movie movie);

}
