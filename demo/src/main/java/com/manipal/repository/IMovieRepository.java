package com.manipal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manipal.model.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer>{
	public Movie findByTitle(String title);
	public Movie findByTitleAndLeadRole(String Title, String leadRole);
}
