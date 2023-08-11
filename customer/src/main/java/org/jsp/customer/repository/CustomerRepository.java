package org.jsp.customer.repository;

import java.util.Optional;

import org.jsp.customer.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("select c from Customer c where c.token=?1")
	public Customer findCustomerByToken(String token);


	@Query("select c from Customer c where c.email=?1 and c.password=?2")
	public Optional<Customer> loginverifyByCustomer(String email, String password);
}
