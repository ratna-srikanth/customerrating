package com.rest.api.customerrating.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.customerrating.dto.CustomerDTO;
import com.rest.api.customerrating.model.Customer;
import com.rest.api.customerrating.model.CustomerMovieRating;
import com.rest.api.customerrating.model.Movie;
import com.rest.api.customerrating.service.CustomerMovieRatingService;
import com.rest.api.customerrating.service.CustomerService;
import com.rest.api.customerrating.service.MovieService;

@RestController
@RequestMapping("/api/rest/customer/")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	MovieService movieService;
	

	
	@Autowired
	CustomerMovieRatingService customerMovieRatingService;

	@PostMapping(value = "/{customer}/movie/{movie}/rate/{rate}")
	public String addRating(@PathVariable("customer") String customerId, @PathVariable("movie") String movieId,
			@PathVariable("rate") String rate) {
		
		String validator = "-?(0|[1-9]\\d*)";
		
		if(!customerId.matches(validator) || !movieId.matches(validator) || !rate.matches(validator)) {
			return "Id should be an integer";
		}
		
		
		Customer customer = customerService.findById(Long.parseLong(customerId));
		Movie movie = movieService.findById(Long.parseLong(movieId));
		//Rating rating = ratingService.findById(Long.parseLong(rateId));
		
		if(null == customer)
			return "Customer not exits";
		if(null == movie)
			return "Movie not exits";
		
		
		CustomerMovieRating customerMovieRating = customerMovieRatingService.findByCustomerMovie(Long.parseLong(customerId), Long.parseLong(movieId));		
		if(customerMovieRating == null) {
			customerMovieRating = new CustomerMovieRating();
			customerMovieRating.setCustomer(customer);
			customerMovieRating.setMovie(movie);
			customerMovieRating.setRating(Double.parseDouble(movieId));
		} else {
			customerMovieRating.setRating(Double.parseDouble(movieId));
		}
		customerMovieRatingService.save(customerMovieRating);
		
		return "Record inserted with id :" +customerMovieRating.getId().toString();
	}
	
	
	@GetMapping(value = "highestMovieRated")
	public String getHighestMovieRated() {
		List<CustomerMovieRating> customerMovieRatings = customerMovieRatingService.findAll();
		
		Map<String, Double> map =
				customerMovieRatings.stream().collect(
						Collectors.groupingBy(
		                p -> p.getMovie().getMovieName(),
		                Collectors.averagingDouble(p -> p.getRating())
		            )
		        );
		
		String highRatedMovie = null; 
				
		try {
			highRatedMovie = map.entrySet().stream()
					  .max(Map.Entry.comparingByValue()).get().getKey();
			return "Highest Movie Rating is :"+highRatedMovie;
		} catch(Exception e) {
			return "No Ratings for the movie exists";
		}
	}
	
	@GetMapping(value = "getAvgHighestRating")
	public CustomerDTO getAvgHighestRating() {
		CustomerDTO dto = new CustomerDTO();
		
		Double avgMaxRating = customerMovieRatingService.getAverageMaximumRating();
		if(null != avgMaxRating) {
			Map<String, Object> result = customerMovieRatingService.getCustomerAverageMaximumRating();
			dto.setId(Long.parseLong(result.get("id").toString()));
			dto.setFirstName(result.get("firstName").toString());
			dto.setLastName(result.get("lastName").toString());
			dto.setCustomerAverageRating(Double.parseDouble(result.get("avgRating").toString()));
			dto.setAverageRating(avgMaxRating);
			return dto;
		}
		
		return dto;
	}
}
