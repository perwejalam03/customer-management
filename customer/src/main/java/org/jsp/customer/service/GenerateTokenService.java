package org.jsp.customer.service;

import org.jsp.customer.dto.EmailConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class GenerateTokenService {
	@Autowired
	private JavaMailSender javaMailSender;

	public String sendWelcomeMail(EmailConfiguration configuration) {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(configuration.getCustomer().get("email"));
			helper.setSubject(configuration.getSubject());
			helper.setText(configuration.getText());
			javaMailSender.send(message);
			return "mail sent successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Unable to send mail";
		}
	}
}
