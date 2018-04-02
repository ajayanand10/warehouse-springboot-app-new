package com.mycompany.myapp.rest;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.dto.EmailService;
import com.mycompany.myapp.dto.UserDTO;
import com.mycompany.myapp.dto.UserDTOService;

@RestController
@RequestMapping("/pages/password")
public class PasswordResetResource {

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserDTOService userService;
	private EmailService emailService;
	
	
	@Autowired
	public PasswordResetResource(BCryptPasswordEncoder bCryptPasswordEncoder, UserDTOService userService,
			EmailService emailService) {
		super();
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userService = userService;
		this.emailService = emailService;
	}
	
	@RequestMapping(value = "/forgot", method = POST, produces = TEXT_PLAIN_VALUE)
	public ResponseEntity<String> forgotPassword(@RequestBody String email,HttpServletRequest request) throws URISyntaxException
	{
		// Lookup user in database by e-mail
		UserDTO userExists = userService.findByEmail(email);
		
		System.out.println(userExists);
		
		if(userExists == null)
			return ResponseEntity.badRequest().header("Failure", "No user with given Email-ID").body("Error : User with provided E-mail does not exist !!!");
		
		else
		{
			userExists.resetToken = UUID.randomUUID().toString();
	        
		    UserDTO savedUser = userService.save(userExists);
		    String appUrl = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort();
			
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(savedUser.email);
			registrationEmail.setSubject("Reset Password");
			registrationEmail.setText("To reset your password, please click the link below:\n"
					+ appUrl + "/pages/password/reset?token=" + savedUser.resetToken);
			registrationEmail.setFrom("ajay.anand10@zoho.com");
			emailService.sendEmail(registrationEmail);
			String resetMessage = "A password reset e-mail has been sent to " + savedUser.email;
			
			return ResponseEntity.created(new URI("/api/users/" + savedUser.id)).body(resetMessage);
		}
		
	}
	
	@RequestMapping(value="/reset", method = GET, produces = TEXT_PLAIN_VALUE)
	public ResponseEntity<String> matchResetLink(@RequestParam("token") String token)
	{
		UserDTO user = userService.findByResetToken(token);
		
		if (user == null) { // No token found in DB
			return ((BodyBuilder) ResponseEntity.notFound().header("Failure", "Invalid Reset link")).body("Failure");
		} 
		else { // Token found
			
			return ResponseEntity.ok().header("Success", "Found match for Reset link").body(new String("Success"));
		}
	}
	
	
	@RequestMapping(value="/reset", method = POST, produces = TEXT_PLAIN_VALUE)
	public ResponseEntity<String> matchResetLink(@RequestParam("token") String token,@RequestBody UserDTO passwordDTO)
	{
		if(!(passwordDTO.password).equals(passwordDTO.confirmPassword))
			return ((BodyBuilder) ResponseEntity.badRequest().header("Failure", "Passwords do not match")).body("Failure");
		
		UserDTO user = userService.findByResetToken(token);
		
		if (user == null) { // No token found in DB
			return ((BodyBuilder) ResponseEntity.notFound().header("Failure", "Invalid Reset link")).body("Failure");
		} 
		else { // Token found
			user.password = bCryptPasswordEncoder.encode(passwordDTO.password);
			user.resetToken=null;
			
			userService.save(user);
			
			return ResponseEntity.ok().header("Success", "Password updated successfully !!").body(new String("Success"));
		}
	}
}
