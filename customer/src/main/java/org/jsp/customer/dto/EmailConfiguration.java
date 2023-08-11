package org.jsp.customer.dto;

import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class EmailConfiguration {
	private Map<String, String> customer;
	private String subject;
	private String text;
}
