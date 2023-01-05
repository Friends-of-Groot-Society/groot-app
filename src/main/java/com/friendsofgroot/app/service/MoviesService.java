package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.Movie;

import java.util.List;

public interface MoviesService {

    Movie createMovies(Movie c);

    Movie getMovies(long id);

    List<Movie> getAllMovies();

    Movie updateMovies(Movie change);

    boolean deleteMovies(long movieId);
}
