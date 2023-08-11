package org.jsp.customer.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.customer.dto.Customer;
import org.jsp.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository repository;

	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}

	public Customer updateCustomer(Customer customer) {
		return repository.save(customer);
	}

	public Customer verifyCustomer(String token) {
		return repository.findCustomerByToken(token);
	}

	public Optional<Customer> findById(int id) {
		return repository.findById(id);
	}

	public void deleteCustomer(int id) {
		repository.deleteById(id);
	}

	public List<Customer> findAllCustomer() {
		return repository.findAll();
	}

	public Optional<Customer> loginverifyByCustomer(String email, String password) {
		return repository.loginverifyByCustomer(email, password);
	}
}
