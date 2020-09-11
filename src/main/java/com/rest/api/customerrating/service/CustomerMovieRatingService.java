package com.rest.api.customerrating.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.customerrating.model.CustomerMovieRating;
import com.rest.api.customerrating.repository.CustomerMovieRatingRepository;


@Service
public class CustomerMovieRatingService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	CustomerMovieRatingRepository repository;

	public void save(final CustomerMovieRating customer) {
		repository.save(customer);
	}
	
	public List<CustomerMovieRating> findAll() {
		Iterable<CustomerMovieRating> it = repository.findAll();
		List<CustomerMovieRating> users = new ArrayList<>();
	    it.forEach(e -> users.add(e));
		return users;
	}

	public CustomerMovieRating findByCustomerMovie(Long custId, Long movieId) {
		return repository.findByCustomerAndMovie( custId,  movieId);
	}
	
	public Double getAverageMaximumRating() {
		return repository.getAverageMaximumRating();
	}
	
	public Map<String, Object> getCustomerAverageMaximumRating() {
		return repository.getCustomerAverageMaximumRating();
	}
	
}
