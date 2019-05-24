package com.app.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.app.example.domain.Employee;
import com.app.example.model.*;
import com.app.example.repository.*;
import java.util.*;

@Controller
public class MyController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping("/addEmployee")  
	 public List<Employee> inserData(@RequestBody Employee employee){
			 //@ModelAttribute Employee employee) {  
	  if (employee != null)  
		  employeeRepository.save(employee);  
	  return employeeRepository.findAll();
	 }  
	
	
	@RequestMapping("/home")  
	 public String showhome() {  
	     return "employee";
	 }  
	
	@RequestMapping("/testEmployee")  
	 public String addemployee() {  
	     return "anemployee";
	 } 
	
	@RequestMapping("/myTest")  
	 public String MyTest() {  
	     return "index.jsp";
	 }  
}
