package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import java.io.*; 
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

import java.io.FileNotFoundException;
import java.util.*;
@SpringBootApplication
@RestController
public class TestDemoApplication implements ApplicationRunner{
	private static final Logger logger = LoggerFactory.getLogger(TestDemoApplication.class);
	public static List<Integer> nlist=new ArrayList<>();
	
	 
	public static void main(String[] args) throws FileNotFoundException{
		SpringApplication.run(TestDemoApplication.class, args);
		 PrintStream ox = new PrintStream(new File("C:/tmp/table.txt")); 
			PrintStream console = System.out; 
			System.setOut(ox); 
			System.out.println("The input data will be written to the text file in the table"); 
		 System.out.println("The Size of table : "+args.length);
		 int l=args.length;
		 System.out.println("Table:");
		 System.out.println("------------------------------------------------------\t");	 
		 if (l <=10) {
		 for(int i=0; i<args.length; i++) {
		  Integer n=Integer.valueOf(args[i]);
		 System.out.printf("%d  %s ",n, "|");
		
		 }
		 }else {
			 for(int i=0; i<10; i++) {
				  Integer n=Integer.valueOf(args[i]);
				 System.out.printf("%d  %s ",n, "|");
				
				 }
		 }
		
		 System.out.println("\n----------------------------------------------------");	 
		 System.setOut(console);
		 System.out.println("\nThe Size of table : "+args.length);
		 System.out.println("Table:");
		 System.out.println("-----------------------------------------------------------\t");	 
		 for(Object o : args){
			 String s=(String)o;
			 Integer t=Integer.valueOf(s);
			 System.out.printf("%d  %s ",t, "|");
		
			 nlist.add(t);
			 
			
			 
		 }
		 System.out.println("\n----------------------------------------------------------");
		 
		
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
    
    	String show="";
    	for(Integer t : nlist) {
    		String result="    <td style='color:blue;border: 1px solid black;'>";
    		String st="";
    		String n =String.valueOf(t);
    		//System.out.println(t+ "  "+n);
    		st=result+n+("</td>\n" );
    		show =show.concat(st);
    		
    	}
    	//System.out.println(show);
		
    	return "<h2 style=\'color:blue;\'>The Table Has been Create As below: </h2>\n<br>"+ "<table style='width:60%'> \n"+ " <tr>\n" + show+"  </tr>\n" + "</table>";
	}
}
