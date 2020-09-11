package com.rest.api.customerrating.dto;

public class CustomerDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private Double customerAverageRating;
	private Double averageRating;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getCustomerAverageRating() {
		return customerAverageRating;
	}
	public void setCustomerAverageRating(Double customerAverageRating) {
		this.customerAverageRating = customerAverageRating;
	}
	public Double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
	
	
}
