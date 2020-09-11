package com.rest.api.customerrating.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.customerrating.model.Movie;
import com.rest.api.customerrating.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository repository;

	public void save(final Movie movie) {
		repository.save(movie);
	}
	
	public Movie findById(Long movieId) {
		Optional<Movie> movie = repository.findById(movieId);
		if(null != movie.get())
			return movie.get();  
		return null;
	}

	// Get all customers from the h2 database.
	public List<Movie> getAll() {
		final List<Movie> movies = new ArrayList<>();
		repository.findAll().forEach(movie -> movies.add(movie));
		return movies;
	}
}
