package com.rest.api.customerrating.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.api.customerrating.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}