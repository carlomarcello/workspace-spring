package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable int id) {	
		
		Customer customer = customerService.getCustomer(id);
		
		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}
		
		return customerService.getCustomer(id);
	}
	
	@PostMapping("/customers")
	public Customer postCustomer(@RequestBody Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer putCustomer(@RequestBody Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	@DeleteMapping("/customers/{id}")
	public Customer deleteCustomer(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
		
		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}
		
		customerService.deleteCustomer(id);
		
		return customer;		
	}
}
