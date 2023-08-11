package org.jsp.customer.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String first_name;
	@Column(nullable = false)
	private String last_name;
	private String street;
	private String address;
	private String city;
	private String state;
	private String email;
	private long phone;
	private String password;
	private String token;
}
