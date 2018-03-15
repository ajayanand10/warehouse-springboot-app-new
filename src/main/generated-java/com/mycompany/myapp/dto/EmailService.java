/*
 * Created Custom by Ajay
 */
package com.mycompany.myapp.dto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * A simple DTO Facility for User.
 */
@Service
public class EmailService {
	
	private JavaMailSender mailSender;

	  @Autowired
	  public EmailService(JavaMailSender mailSender) {
	    this.mailSender = mailSender;
	  }
	  
	  @Async
	  public void sendEmail(SimpleMailMessage email) {
	    mailSender.send(email);
	  }
}