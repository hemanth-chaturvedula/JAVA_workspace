package com.manipal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.Movie;
import com.manipal.repository.IMovieRepository;
//import com.manipal.service.utility.MovieValidationCheck;

@Service
public class MovieServiceImpl implements IMovieService {

	@Autowired
	private IMovieRepository repository;
	/*
	@Override
	public String addMovie(Movie movie) {		
		//lead role should not contain any special character/number
		
		String validationStatus = "Not validated";
		
		if (MovieValidationCheck.validateMovie(movie)) {
			repository.save(movie);
			validationStatus = "Validated";
		}
		else {
			validationStatus = "Not Validated";
		}
		return validationStatus;
	}
	*/
	
	@Override
	public void addOrUpdateMovie(Movie movie) {
		repository.save(movie);
	}
	/*Not required to have a separate method
	public void updateMovie(Movie movie) {
		repository.save(movie);
	}
	*/
	
	@Override
	public Movie getMovieById(int movieId) {
		return repository.findById(movieId).orElse(null);
	}
	
	@Override
	public Movie getMovieByName(String movieName) {
		return repository.findByTitle(movieName);
	}
	
	@Override
	public void deleteMovie(Movie movie) {
		repository.delete(movie);
	}
	
	@Override
	public Iterable<Movie> listAllMovies() {
		return repository.findAll();
	}
	
	@Override
	public Movie getMovieByNameandLeadRole(String movieName,String leadrole) {
		return repository.findByTitleAndLeadRole(movieName,leadrole);
	}
	
}
