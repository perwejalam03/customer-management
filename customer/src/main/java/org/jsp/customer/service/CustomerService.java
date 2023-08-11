package org.jsp.customer.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.jsp.customer.dao.CustomerDao;
import org.jsp.customer.dto.Customer;
import org.jsp.customer.dto.EmailConfiguration;
import org.jsp.customer.dto.ResponseStructure;
import org.jsp.customer.exception.IdNotFoundException;
import org.jsp.customer.exception.InvalidCrediantialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao dao;
	@Autowired
	private GenerateTokenService mailService;
	@Autowired
	private EmailConfiguration configuration;
	@Autowired
	private GenerateLink service;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer, HttpServletRequest request) {
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		structure.setData(dao.saveCustomer(customer));
		structure.setMessage("Customer Registration successfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		configuration.setSubject("Registration successfull");
		HashMap<String, String> map = new LinkedHashMap<>();
		map.put("email", customer.getEmail());
		map.put("name", customer.getFirst_name());
		configuration.setText("Hello Mr." + customer.getFirst_name()
				+ " You have successfully initiated the registration for Our E-Commerce application "
				+ "please click on the link to activate your account "
				+ service.getVerificationLink(request, customer));
		configuration.setCustomer(map);
		mailService.sendWelcomeMail(configuration);
		return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer) {
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		structure.setData(dao.updateCustomer(customer));
		structure.setMessage("Customer Updated successfull");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.ACCEPTED);
	}


	public ResponseEntity<ResponseStructure<Customer>> loginverifyByCustomer(String email, String password) {
		Optional<Customer> recCustomer = dao.loginverifyByCustomer(email, password);
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		if (recCustomer.isPresent()) {
			structure.setData(recCustomer.get());
			structure.setMessage("Customer Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		}
		throw new InvalidCrediantialException();
	}

	public ResponseEntity<ResponseStructure<Customer>> findCustomer(int id) {
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		Optional<Customer> recCustomer = dao.findById(id);
		if (recCustomer.isPresent()) {
			structure.setData(recCustomer.get());
			structure.setMessage("Customer Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteCustomer(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Customer> recCustomer = dao.findById(id);
		if (recCustomer.isPresent()) {
			dao.deleteCustomer(id);
			structure.setMessage("Customer Deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomer() {
		ResponseStructure<List<Customer>> structure = new ResponseStructure<>();
		structure.setData(dao.findAllCustomer());
		structure.setMessage("Customer Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Customer>>>(structure, HttpStatus.OK);
	}
}
