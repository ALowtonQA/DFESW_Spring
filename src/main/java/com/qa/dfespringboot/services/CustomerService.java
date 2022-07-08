package com.qa.dfespringboot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dfespringboot.entities.Customer;
import com.qa.dfespringboot.repos.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo repo;
	
	public CustomerService(CustomerRepo repo) {
		this.repo = repo;
	}
	
	//GET - READ
	//ReadAll
	public List<Customer> readAll() {
		return this.repo.findAll();
	}
	
	//ReadByID
	public Customer readById(long id) {
		return this.repo.findById(id).get();
	}
	
	//ReadByFirstName
	public List<Customer> readByFirstName(String firstName) {
		return this.repo.findCustomerByFirstName(firstName);
	}
	
	//POST - CREATE
	public Customer create(Customer customer) {
		return this.repo.saveAndFlush(customer);
	}
	
	//PUT - UPDATE
	public Customer update(long id, Customer customer) {
		//1) Get the existing entry.
		Customer existing = this.repo.findById(id).get();
		
		//2) Change the existing entry, using our new customer object above.
		existing.setFirstName(customer.getFirstName());
		existing.setLastName(customer.getLastName());
		existing.setEmail(customer.getEmail());
		
		//3) Save the entry back into the Database.
		return this.repo.saveAndFlush(existing);
	}
	
	
	//DELETE - DELETE
	public boolean delete(long id) {
		this.repo.deleteById(id);
		
		return !this.repo.existsById(id); // this should be false. If it's true, then the delete failed, somehow.
	}
}
