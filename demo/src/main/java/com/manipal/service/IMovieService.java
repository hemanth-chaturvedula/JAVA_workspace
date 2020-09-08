package com.manipal.service;

import com.manipal.model.Movie;

public interface IMovieService {
	
	 void addOrUpdateMovie(Movie movie);
	 Movie getMovieById(int movieId);
	 void deleteMovie(Movie movie);
	 Iterable<Movie> listAllMovies();
	 Movie getMovieByName(String movieName);
	 Movie getMovieByNameandLeadRole(String movieName,String leadrole);
}
