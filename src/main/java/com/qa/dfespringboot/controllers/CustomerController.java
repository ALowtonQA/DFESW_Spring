package com.qa.dfespringboot.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.dfespringboot.entities.Customer;
import com.qa.dfespringboot.services.CustomerService;

// Handle incoming HTTP requests and send responses
// Uses JSON data
@RestController
@RequestMapping("/customer") // adds a prefix to the request URLs
public class CustomerController {

	private CustomerService service;
	
	// Dependency injection
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	//GET - READ
	//ReadAll
	@GetMapping("/readAll")
	public List<Customer> readAll() {
		return this.service.readAll();
	}
	
	//ReadByID
	@GetMapping("/readById/{id}")
	public Customer readById(@PathVariable long id) {
		return this.service.readById(id);
	}
	
	//POST - CREATE
	@PostMapping("/create") // localhost:8080/customer/create
	public Customer create(@RequestBody Customer customer) {
		return this.service.create(customer);
	}
	
	//PUT - UPDATE
	@PutMapping("/update/{id}")
	public Customer update(@PathVariable long id, @RequestBody Customer customer) {
		return this.service.update(id, customer);
	}
	
	//DELETE - DELETE
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return this.service.delete(id);
	}
}
