package com.qa.dfespringboot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dfespringboot.entities.Customer;

@Service
public class CustomerService {

	// TEMPORARY storage, until we implement the real database later!
	private List<Customer> customers = new ArrayList<>();
	
	//GET - READ
	//ReadAll
	public List<Customer> readAll() {
		return this.customers;
	}
	
	//ReadByID
	public Customer readById(int id) {
		return this.customers.get(id);
	}
	
	//POST - CREATE
	public Customer create(Customer customer) {
		this.customers.add(customer);
		
		// Returns the latest entry added to the list
		return this.customers.get(this.customers.size() - 1);
	}
	
	//PUT - UPDATE
	public Customer update(int id, Customer customer) {
		// Removing the original customer
		this.customers.remove(id);
		
		// Add the updated customer
		this.customers.add(id, customer);
		
		// Return the updated user
		return this.customers.get(id);
	}
	
	//DELETE - DELETE
	public Customer delete(int id) {
		return this.customers.remove(id);
	}
}
