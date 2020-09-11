package com.rest.api.customerrating;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rest.api.customerrating.model.Customer;
import com.rest.api.customerrating.model.Movie;
import com.rest.api.customerrating.repository.CustomerRepository;
import com.rest.api.customerrating.repository.MovieRepository;

@SpringBootApplication
public class CustomerRatingApplication {


	public static void main(String[] args) {
		SpringApplication.run(CustomerRatingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository, MovieRepository movieRepository) {
		return (args) -> {
			// save a few customers
			customerRepository.save(new Customer("Jack", "Bauer"));
			customerRepository.save(new Customer("Chloe", "O'Brian"));
			customerRepository.save(new Customer("Kim", "Bauer"));
			customerRepository.save(new Customer("David", "Palmer"));
			customerRepository.save(new Customer("Michelle", "Dessler"));
			
			
			movieRepository.save(new Movie("Inception"));
			movieRepository.save(new Movie("Gladiator"));
			movieRepository.save(new Movie("300 Warriors"));
			movieRepository.save(new Movie("Twilight"));
			movieRepository.save(new Movie("Annabelle"));
			
			/*rateRepository.save(new Rating(1));
			rateRepository.save(new Rating(2));
			rateRepository.save(new Rating(3));
			rateRepository.save(new Rating(4));
			rateRepository.save(new Rating(5));*/

		};
	}
}
