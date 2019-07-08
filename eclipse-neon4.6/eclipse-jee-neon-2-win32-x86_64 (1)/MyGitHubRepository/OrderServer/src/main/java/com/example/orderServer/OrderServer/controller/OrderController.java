package com.example.orderServer.OrderServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.orderServer.OrderServer.domain.*;
//import com.netflix.client.http.HttpHeaders;

//@RestController
@Controller
@RequestMapping("/productOrder")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
   
	 @Autowired
	 RestTemplate restTemplate;
    
    @Autowired
    private WebClient.Builder webClientBuilder;
	
    @GetMapping(path="/getProducts")
    @ResponseBody
	public List<Product> showPurchase() {
		
		String url="http://DB-DATA-SERVER/data/getAlls";
		//List<Person> plist=new ArrayList<Person>();
		List<Product> dlist=new ArrayList<Product>();
		
		Product[] products = restTemplate.getForObject(url, Product[].class);
				//restTemplate.getForObject(url, Product[].class);
		
		if (products !=null) {
			
			for(Product pd : products) {
				dlist.add(pd);
			}
		}
		
		return dlist;
		
	 }
    
    
    @GetMapping(path="/getOneCustomer/{id}")
    @ResponseBody
     public Person getCustomerForPerson(@PathVariable("id") final Integer id) {
    	String url="http://DB-DATA-SERVER/data/getOneCustomer/"+id;
    	
        Customer customer = webClientBuilder.build()
    	.get()
    	.uri(url)
    	.retrieve()
    	.bodyToMono(Customer.class)
    	.block();
    	 System.out.println("\n----->"+customer.getName()+"  "+customer.getPcid());
    	 
    	 List<Product> list= showPurchase();
    	 
     
    	 List<Product> clist=list.parallelStream().filter(p -> p.getId().equalsIgnoreCase(customer.getPcid())).collect(Collectors.toList());
    		 
    		
    	 
    	 Person person=new Person(customer.getCardNumber(), customer.getName(), clist);
    	 
    	 
    return person;
    	                        
     }
    
    @GetMapping(path="/getBuyer/{name}")
    @ResponseBody
    public List<Person> makePersons(@PathVariable("name") String name) {
    
    	String url= "http://DB-DATA-SERVER/data/getCustomers";
   	    List<Product> dlist= showPurchase();
   	 
   	    List<Person> plist=new ArrayList<Person>();
   	 
   	    List<Customer> clist= new ArrayList<Customer>();
   	 
   
   	 
   	    Customer[] customers= restTemplate.getForObject(url, Customer[].class);
   	 
     	 if (customers !=null) {
   	    	 for (Customer c : customers) {
   			 clist.add(c);
   		   }
   	   }//end if
     	 
     plist= clist.stream().filter(c -> c.getName().equalsIgnoreCase(name)).map(c -> {
     		String pdtId=c.getPcid();
     		System.out.println("\nThe Product ID: "+ pdtId);
     		 List<Product>  pslist=dlist.stream().filter(p -> p.getId().equalsIgnoreCase(pdtId)).collect(Collectors.toList());
     		System.out.println("The Product:  "+pslist.get(0));
     		
     		String pd=String.valueOf(c.getId());
     		
     		return new Person(pd, c.getName(), pslist);
     		
     	 }).collect(Collectors.toList());
     	
     	return plist;
     	
     	//return clist;//.stream().filter(c -> c.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
     	
    }
    
    @GetMapping(path="/getPerson/{cid}")
    @ResponseBody
    public Person showPersons(@PathVariable("cid") final String cid) {
   	 
   	 String url= "http://DB-DATA-SERVER/data/getCustomers";
   	 List<Product> dlist= showPurchase();
   	 
   	 List<Person> plist=new ArrayList<Person>();
   	 
   	 List<Customer> clist= new ArrayList<Customer>();
   	 
   	 List<Product> psclist= new ArrayList<Product>();
   	 
   	 Customer[] customers= restTemplate.getForObject(url, Customer[].class);
   	 
   	 if (customers !=null) {
   		 for (Customer c : customers) {
   			 clist.add(c);
   		 }
   	 }
   	 // List<Product>  pslist=dlist.stream().filter(p -> p.getId().equalsIgnoreCase(pdtId)).collect(Collectors.toList());
   	 //public Person(String id, String name, List<Product> product) 
   	 plist=clist.stream().filter(c -> c.getCardNumber().equals(cid)).map(c -> {
   		            String pdtId=c.getPcid();
   		           // Integer cpid=c.getId();
   		           List<Product>  pslist=dlist.stream().filter(p -> p.getId().equalsIgnoreCase(pdtId)).collect(Collectors.toList());
   		        psclist.addAll(pslist);
   		           String pp=String.valueOf(cid);
   	                 return new Person(pp, c.getName(), pslist);
   	         }
   	 ).collect(Collectors.toList()); 
   	 
   	 for(Product ps : psclist) {
   		 System.out.println("*****----"+ps.toString());
   	 }
     
   	     Person ps=plist.get(0);
   	     ps.setProduct(psclist);
   	     ps.setId(ps.getId());
   	     ps.setName(ps.getName());
          return ps;
   	                        
    }
    
    
    @PostMapping("/product")
    @ResponseBody
	public String createEmployee(@Valid @RequestBody Product product, HttpServletRequest request, @RequestHeader(value="Accept") String acceptType){
		
		  logger.info("Accept : ->" + acceptType);
		  logger.info("The URI -->"+request.getRequestURI());
		  logger.info("The request header: "+request.getHeader("Content-Type"));
		
		  String url= "http://DB-DATA-SERVER/data/saveProduct";
          // headers: { "Content-Type": "application/json" }
		  //ResponseEntity<String> result = restTemplate.postForEntity(url, product, String.class);
		     
		  HttpHeaders header =new HttpHeaders();
		  header.setContentType(MediaType.APPLICATION_JSON);
		  ResponseEntity<String> result = restTemplate.postForEntity(url, product, String.class);
	
	return result.getBody();

}
    
    
}
