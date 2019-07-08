package com.example.orderServer.OrderServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

	@GetMapping(path="/show")
	//@ResponseBody
    public String showme(){
  	
  	  return "index";
    }
    
    @GetMapping(path="/shows")
    public String showme2(){
  	
  	  return "test";
    }
}
