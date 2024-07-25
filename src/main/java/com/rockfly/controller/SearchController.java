package com.rockfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rockfly.models.Customers;
import com.rockfly.repositories.CustomersRepository;

@RestController
public class SearchController {

	@Autowired
	private CustomersRepository customersRepository;
	
	
	//search handler
	@GetMapping("/search/{query}")
	public ResponseEntity<?> search(@PathVariable("query") String query) {
		
		System.out.println(query);
		List<Customers> customers=this.customersRepository.findByPartyNameOrCityContaining(query);
		return ResponseEntity.ok(customers);
	}

}
