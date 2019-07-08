package com.example.orderServer.OrderServer.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Customer {

    private Integer id;
	
	private String name;
	
	private String cardNumber;
	
	private String pcid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPcid() {
		return pcid;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}
//{"id":100,"name":"6548901256","cardNumber":"Jeff Smith","pcid":"1111"}
	public Customer(Integer id, String name, String cardNumber, String pcid) {
		super();
		this.id = id;
		this.name = name;
		this.cardNumber = cardNumber;
		this.pcid = pcid;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", cardNumber=" + cardNumber + ", pcid=" + pcid + "]";
	}

	

	
}
