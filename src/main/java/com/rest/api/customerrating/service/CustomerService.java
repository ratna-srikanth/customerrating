package com.rest.api.customerrating.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.customerrating.model.Customer;
import com.rest.api.customerrating.repository.CustomerRepository;

@Service
public class CustomerService {

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	CustomerRepository repository;

	// Save customer entity in the h2 database.
	public void save(final Customer customer) {
		repository.save(customer);
	}
	
	public Customer findById(Long customerId) {
		Optional<Customer> customer = repository.findById(customerId);
		if(null != customer.get())
			return customer.get();  
		return null;
	}

	// Get all customers from the h2 database.
	public List<Customer> getAll() {
		final List<Customer> customers = new ArrayList<>();
		repository.findAll().forEach(customer -> customers.add(customer));
		return customers;
	}
}
