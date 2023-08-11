package org.jsp.customer.controller;

import java.util.List;

import org.jsp.customer.dto.Customer;
import org.jsp.customer.dto.ResponseStructure;
import org.jsp.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("http://localhost:3000/")
public class CustomerController {
	@Autowired
	private CustomerService service;

	private final String AUTH_API_URL = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";
	private final String CUSTOMER_API_URL = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp";

	@PostMapping("/createCustomer")
	public ResponseEntity<ResponseStructure<Customer>> savCustomer(@RequestBody Customer customer,
			HttpServletRequest request) {
		return service.saveCustomer(customer, request);
	}

	@PostMapping("/updateCustomer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}

	@GetMapping("/getCustomerList")
	public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomer() {
		return service.findAllCustomer();
	}

	@PostMapping("/deleteCustomer")
	public ResponseEntity<ResponseStructure<String>> deleteCustomer(@PathVariable int id) {
		return service.deleteCustomer(id);
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<Customer>> loginverifyByCustomer(@RequestParam String email,
			@RequestParam String password) {
		return service.loginverifyByCustomer(email, password);
	}
	@GetMapping("/customer/{id}")
	public ResponseEntity<ResponseStructure<Customer>> findCustomer(@PathVariable int id) {
		return service.findCustomer(id);
	}

}
