package com.qa.dfespringboot.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dfespringboot.entities.Customer;

// JpaRespository requires both the Entity, and the datatype for the id column. This must be the Object version.
// So long = Long, int = Integer.
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	// SELECT * FROM customer WHERE first_name = firstName;
	List<Customer> findCustomerByFirstName(String firstName);
	
}
