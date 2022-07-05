package com.qa.dfespringboot.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	// Define Table Columns
	@Id // Sets the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // enables AUTO_INCREMENT
	private long id;
	
	@Column(name = "firstname", nullable = false) // This annotation takes control of the naming of the column
	private String firstName;  // Produces a column called: first_name by default. It will be firstname because we set it above/
	
	@Column(nullable = false)
	private String lastName; // Produces a column called: last_name
	
	@Column(nullable = false, unique = true)
	private String email;

	// Default constructor - Spring needs this to function
	public Customer() {}

	// No ID constructor - used for inserting
	public Customer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	//  All args constructor - used for reading	
	public Customer(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// For testing
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}

}
