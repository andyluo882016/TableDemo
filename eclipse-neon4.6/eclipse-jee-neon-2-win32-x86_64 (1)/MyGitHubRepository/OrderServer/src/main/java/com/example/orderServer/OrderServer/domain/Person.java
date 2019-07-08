package com.example.orderServer.OrderServer.domain;
import java.util.*;

import lombok.Data;
@Data
public class Person {

	private String id;
	
	private String name;
	
	private List<Product> product;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Person(String id, String name, List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", product=" + product + "]";
	}
	
	
}
