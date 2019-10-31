package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.*;
@SpringBootApplication
@RestController
public class TestDemoApplication implements ApplicationRunner{
	private static final Logger logger = LoggerFactory.getLogger(TestDemoApplication.class);
	public static List<Integer> nlist=new ArrayList<>();
	
	 
	public static void main(String[] args) {
		SpringApplication.run(TestDemoApplication.class, args);
		//List<Integer> slist =new LinkedList<Integer>();
		 System.out.println(args.length);
		 System.out.println("arges  --"+args[0].toString());
		 //list.add(89);
		 for(Object o : args){
			 String s=(String)o;
			 Integer t=Integer.valueOf(s);
			 
			 System.out.println("---> "+t);
			 nlist.add(t);
			 
			
			 
		 }
		 
		
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		 args.getOptionNames().forEach(optionName -> {
	            System.out.println(optionName + "=" + args.getOptionValues(optionName));
	          String t=(String)String.valueOf(args.getOptionValues(optionName));
	          Integer m=Integer.valueOf(t);
	          logger.info("number: "+m);
	            
	        });
		 
		 
		 
		
	}
    @GetMapping(path="/showtable")
	public String myoutput() {
    	
    	Integer m=nlist.get(0);
    	Integer m1=nlist.get(1);
    	Integer m2=nlist.get(2);
    	Integer m3=nlist.get(3);
    	Integer m4=nlist.get(4);
    	Integer m5=nlist.get(5);
    	Integer m6=nlist.get(6);
    	Integer m7=nlist.get(7);
    	Integer m8=nlist.get(8);
    	Integer m9=nlist.get(9);
		return "<table> "
				+ " <tr>\n" + 
				"    <td>"+m+"</td>\n" + 
				"    <td>"+m1+"</td>\n" + 
				"    <td>"+m2+"</td>\n" +
				"    <td>"+m3+"</td>\n" +
				"    <td>"+m4+"</td>\n" +
				"    <td>"+m5+"</td>\n" +
				"    <td>"+m6+"</td>\n" +
				"    <td>"+m7+"</td>\n" +
				"    <td>"+m8+"</td>\n" +
				"    <td>"+m9+"</td>\n" +
				"  </tr>\n" + 
				"</table>";
	}
}
