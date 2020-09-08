package com.manipal.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.exception.MovieNotFoundException;
import com.manipal.model.Movie;
import com.manipal.service.IMovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private IMovieService movieService;
	
	//@RequestMapping(value="addmovie", method=RequestMethod.POST)
	//@PostMapping("addmovie")
	//the above methods are equivalent
	@PostMapping	//works when there is only one post method without the url
	public String addMovieDetails(@RequestBody Movie movie) {
		System.out.println(movie);
		movieService.addOrUpdateMovie(movie);
		return "Movie added successfully";
	}
	
	@PostMapping("update")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movieDetails) {
		Movie movie = movieService.getMovieById(movieDetails.getMovieId());
		if(movie!=null) {	
			movie.setTitle(movieDetails.getTitle());
			movie.setBudget(movieDetails.getBudget());
			movieService.addOrUpdateMovie(movie);
		}
		else {
			movieService.addOrUpdateMovie(movieDetails);
			movie = movieDetails;
		}
		ResponseEntity<Movie> responseEntity = new ResponseEntity<Movie>(movie, HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("delete")
	public String deleteMovie(@RequestBody Movie movieDetails) {
		Movie movie = movieService.getMovieById(movieDetails.getMovieId());
		if(movie!=null) {
			movieService.deleteMovie(movie);
			return "Movie Succesfully deleted";
		}
		else {
			movieService.addOrUpdateMovie(movieDetails);
			movie = movieDetails;
			return "Requested movie does not exist in the database";
		}
	}
	
	@GetMapping("allmovies")
	public List<Movie> findAllMovies() {
		Iterable<Movie> source =  movieService.listAllMovies();
		List<Movie> target = new ArrayList<>();
		source.forEach(target::add);
		return target;
	}
	
	
	@GetMapping("/id/{movieId}")
	public Movie getMovieById(@PathVariable int movieId) {
		Movie movie = movieService.getMovieById(movieId);
		if (movie==null)
			throw new MovieNotFoundException("Movie ID is invalid. Please enter correct ID.");
		return movie;
	}
	
	@GetMapping("/name/{movieName}")
	public Movie getMovieByName(@PathVariable String movieName) {
		Movie movie = movieService.getMovieByName(movieName);
		if (movie==null)
			throw new MovieNotFoundException("Movie Name is invalid. Please enter correct ID.");
		return movie;
	}
		
	@GetMapping("/nameandrole/{movieName}/{leadrole}")
	public Movie getMovieByNameandLeadRole(@PathVariable String movieName,@PathVariable String leadrole) {
		Movie movie = movieService.getMovieByNameandLeadRole(movieName,leadrole);
		if (movie==null)
			throw new MovieNotFoundException("Movie ID is invalid. Please enter correct ID.");
		return movie;
	}
	
	
	
}
