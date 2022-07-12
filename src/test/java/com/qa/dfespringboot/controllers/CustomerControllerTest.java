package com.qa.dfespringboot.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dfespringboot.entities.Customer;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CustomerControllerTest {

	@Autowired
	private MockMvc mvc; // used for sending mock requests
	
	@Autowired
	private ObjectMapper mapper; // used for converting objects to JSON
	
	@Test
	public void createTest() throws Exception {
		Customer entry = new Customer("A", "L", "al@qa.com");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Customer result = new Customer(2L, "A", "L", "al@qa.com");
		String resultAsJSON = mapper.writeValueAsString(result);

		mvc.perform(post("/customer/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));

	}
	
	@Test
	public void readAllTest() throws Exception {
		// Setting up my expected output object
		List<Customer> output = new ArrayList<>();
		Customer entry = new Customer(1L, "Anoush", "Lowton", "alowton@qa.com");
		output.add(entry);
		// Convert my expected output to JSON
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/customer/readAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(outputAsJSON));

	}
	
	@Test
	public void readByIdTest() throws Exception {
		Customer entry = new Customer(1L, "Anoush", "Lowton", "alowton@qa.com");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		mvc.perform(get("/customer/readById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		Customer entry = new Customer("A", "L", "al@qa.com");
		Customer result = new Customer(1L, "A", "L", "al@qa.com");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(put("/customer/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/customer/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string("true"));
	}
	
}
