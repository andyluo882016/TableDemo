package com.example.dbserver.DBDataServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dbserver.DBDataServer.domain.*;
import com.example.dbserver.DBDataServer.repository.CustomerRepository;
import com.example.dbserver.DBDataServer.repository.DBRepository;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/data")
public class DBServerController {
	
	private static final Logger logger = LoggerFactory.getLogger(DBServerController.class);
    
	@Autowired
	DBRepository dBRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping(path="/getOne/{id}")
	public Product getOneProduct(@PathVariable("id") final String id) {
		logger.info("****  get one Product Item ********");
		return dBRepository.getOneById(id);
	}
	
	@GetMapping(path="/getAlls")
	public List<Product> getAllProducts() {
		logger.info("****  get All Product List ********");
		return dBRepository.findAll();
	}
	
	@GetMapping(path="/getOneCustomer/{id}")
	public Customer getCustomerById(@PathVariable("id") final Integer id) {
		logger.info("****  get One Customer ********");
		
		return customerRepository.getCustomerById(id);
	}
	
	@GetMapping(path="/getCustomers")
	public List<Customer> getAllCustomer() {
	
		logger.info("****  get All Customer List ********");
		
		return customerRepository.findAll();
	}
	@PostMapping(path="/saveOne")
	public Customer updatedCustomer(@Validated @RequestBody Customer customer) {
		
		customerRepository.save(customer);
		
		Integer id=customer.getId();
		
		return  customerRepository.getCustomerById(id);
	}
	
	@PostMapping(path="/saveProduct")
	public void saveProduct(@Validated @RequestBody Product product) {
		
		dBRepository.save(product);
		
		//Integer id=customer.getId();
		
		//return  customerRepository.getCustomerById(id);
	}
	
	@PostMapping(path="/saveCustomer")
	public void saveCustomer(@Validated @RequestBody Customer customer) {
		
		customerRepository.save(customer);
	}
	
}
