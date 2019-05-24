package com.app.example.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.app.example.model.*;
import com.app.example.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping("/alls")
	public List<Employee> findEmployees(){
		
		return employeeRepository.findAll();
	}
	
	 @RequestMapping (value="/getOne/{id}", method=RequestMethod.GET)
	    public Employee getEmployee(@PathVariable("id") Integer id){
	    	
	    	return employeeRepository.findEmployeeByid(id);
	    }
	
	@RequestMapping("/update/{id}/{email}")
	public Employee updateOne(@PathVariable("id") Integer id, @PathVariable("email")String email){
		Employee emp=employeeRepository.findEmployeeByid(id);
		
		emp.setEmail(email);
		emp.setFirstname("Jeff");
		emp.setLastname("Kevens");
		employeeRepository.saveAndFlush(emp);
		Employee nmpa=employeeRepository.findEmployeeByid(id);
		return nmpa;
	}
	@RequestMapping("/test/{name}")
	public String TestMe(@PathVariable("name")String name){
		return "Hello Spring Boot Testing "+ name;
		
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeRepository.deleteById(id);
	}
	
	//@PostMapping("/employees")ResponseEntity<Void>
	//public List<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		
		@PostMapping("/employees")
		public String createEmployee(@Valid @RequestBody Employee employee, HttpServletRequest request, @RequestHeader(value="Accept") String acceptType)throws URISyntaxException {
			/*Employee employee =new Employee();
			employee.setId(104);
			employee.setFirstname("Luner");
			employee.setLastname("Methuter");
			employee.setEmail("Lunert@test.com");*/ 
			  logger.info("Accept : ->" + acceptType);
			  logger.info("The URI -->"+request.getRequestURI());
			  logger.info("The request header: "+request.getHeader("Content-Type"));
			
		Employee savedEmployee = employeeRepository.save(employee);

		/*URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEmployee.getId()).toUri();

		return ResponseEntity.created(location).build();*/
		// ResponseEntity.created(new URI("/alls")).build();
		//return ResponseEntity.created(new URI("/employee/"+savedEmployee.getId())).build();
		//return employeeRepository.findAll();
		
		return "index";

	}
	
	@PostMapping("/insert")  
	 public List<Employee> inserData(@ModelAttribute Employee employee, HttpServletRequest request, @RequestHeader(value="Accept") String acceptType) {  
		  logger.info("Accept : " + acceptType);
		  logger.info("The URI -->"+request.getRequestURI());
	  if (employee != null)  
		  employeeRepository.save(employee);  
	  return employeeRepository.findAll();
	 }  
	
	@RequestMapping(value="/showall", produces = "application/json")
	public List<Employee> showallEmp(){
		
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> showOneEmployee(@PathVariable Integer id) {

	    Employee employee = employeeRepository.findEmployeeByid(id);
	    String version = employee.getEmail();

	    return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS))
	            .eTag(version) // lastModified is also available
	            .body(employee);
	}
	
	@RequestMapping("/empl/{name}/{id}")
	@ResponseBody
	public ResponseEntity<String> TestHttpChaching(@PathVariable("name")String name, @PathVariable("id") Integer id){
                Employee employee =employeeRepository.findEmployeeByid(id);
                String fname =employee.getFirstname()+" -- "+name;
                CacheControl cacheControl = CacheControl.maxAge(10, TimeUnit.SECONDS);

                String testBody = fname+ "<p>@ Response time: " + LocalDateTime.now() +
                          "</p><a href=''>test-Empl</a>"+ "\n "+"<p>"+fname +"</p>";
                return ResponseEntity.ok()
                                     .cacheControl(cacheControl)
                                     .eTag(fname)
                                     .body(testBody); // the time of lastModified is also available in 10 second
		
	}
	
	
	@RequestMapping("/empl/{id}")
	@ResponseBody
	public ResponseEntity<String> MyHttpChaching(@PathVariable("id") Integer id){
                Employee employee =employeeRepository.findEmployeeByid(id);
                String fname =employee.getEmail();
                CacheControl cacheControl = CacheControl.maxAge(10, TimeUnit.SECONDS);

                String testBody = fname+ "<p>@ Response time: " + LocalDateTime.now() +
                          "</p><a href=''>test-Empl</a>"+ "\n "+"<p>"+employee.getEmail() +"</p>";
                return ResponseEntity.ok()
                                     .cacheControl(cacheControl)
                                     //.eTag(fname)
                                     .body(testBody); // the time of lastModified is also available in 10 second
		
	}
	
	
	
}
