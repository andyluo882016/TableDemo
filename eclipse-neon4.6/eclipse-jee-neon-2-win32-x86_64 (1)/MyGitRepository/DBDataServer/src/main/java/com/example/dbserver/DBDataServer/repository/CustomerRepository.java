package com.example.dbserver.DBDataServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dbserver.DBDataServer.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

      // public List<Customer> findAllCustomers();
	
	public Customer getCustomerById(Integer id);
}
