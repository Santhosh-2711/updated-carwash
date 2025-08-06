package com.billing.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SetPrices {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@JsonProperty("seating_capacity")
	private Integer seating_capacity;
	@JsonProperty("price")
	private Integer price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSeating_capacity() {
		return seating_capacity;
	}
	public void setSeating_capacity(Integer seating_capacity) {
		this.seating_capacity = seating_capacity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public SetPrices(Integer id, Integer seating_capacity, Integer price) {
		super();
		this.id = id;
		this.seating_capacity = seating_capacity;
		this.price = price;
	}
	public SetPrices() {
		super();
	}
	
	
	
	

}
