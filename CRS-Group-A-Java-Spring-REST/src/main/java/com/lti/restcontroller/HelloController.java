package com.lti.restcontroller;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bean.Customer;

@RestController
public class HelloController {
	
	@GetMapping("/HelloRest")
	public String helloController() {
		return "My first rest service";
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/details")
		@ResponseBody
			public Customer details(){
				
				Customer c1=new Customer();
				c1.setCustomerId(21);
				c1.setCustomerName("Amit");
				c1.setCustomerAddress("Noida");
				
				return c1;
				
			}
}
