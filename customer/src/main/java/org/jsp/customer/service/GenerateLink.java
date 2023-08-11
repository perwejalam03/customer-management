package org.jsp.customer.service;

import org.jsp.customer.dao.CustomerDao;
import org.jsp.customer.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;
@Service
public class GenerateLink {

	@Autowired
	private CustomerDao dao;

	public String getVerificationLink(HttpServletRequest request, Customer customer) {
		String token = RandomString.make(45);
		customer.setToken(token);
		dao.updateCustomer(customer);
		String siteurl = request.getRequestURL().toString();
		String url = siteurl.replace(request.getServletPath(), "");
		String verify_link = url + "/users/verify?token=" + token;
		return verify_link;
	}
}
