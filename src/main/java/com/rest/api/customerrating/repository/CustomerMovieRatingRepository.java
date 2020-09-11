package com.rest.api.customerrating.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rest.api.customerrating.model.CustomerMovieRating;

public interface CustomerMovieRatingRepository extends CrudRepository<CustomerMovieRating, Long> {

	@Query(value = "SELECT * FROM customer_movie_rating  WHERE customer_id = ?1 and movie_id = ?2", nativeQuery = true)
	CustomerMovieRating findByCustomerAndMovie(Long custId, Long movieId);
	
	@Query(value = "select  max(avg_rating) from (select  avg(rating) AS avg_rating from CUSTOMER_MOVIE_RATING group by movie_id) As maxRating;", nativeQuery = true)
	public Double getAverageMaximumRating();
	
	@Query(value = "select cmr.customer_id as id, cust.first_name as firstName, cust.last_name as lastName, avg(cmr.rating)  as avgRating from CUSTOMER_MOVIE_RATING cmr JOIN customer cust ON  cust.customer_id = cmr.customer_id  group by cmr.customer_id  order by avgRating desc limit 1", nativeQuery = true)
	public Map<String, Object> getCustomerAverageMaximumRating();

  
}