package com.mycompany.myapp.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.dto.EmailService;
import com.mycompany.myapp.dto.UserDTO;
import com.mycompany.myapp.dto.UserDTOService;


@RestController
@RequestMapping("/pages")
public class RegisterResource {
	
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserDTOService userService;
	private EmailService emailService;
 
    @Autowired
    public RegisterResource(//BCryptPasswordEncoder bCryptPasswordEncoder,
    		UserDTOService userService, EmailService emailService) {
      
//      this.bCryptPasswordEncoder = bCryptPasswordEncoder;
      this.userService = userService;
      this.emailService = emailService;
    }

	// Return registration form template
	/*@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user){
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return ResponseEntity.ok().body(result);
	}*/
	
	// Process form input data
	@RequestMapping(value = "/register", method = POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> processRegistration(@RequestBody UserDTO userDTO, HttpServletRequest request) throws URISyntaxException {
				
		// Lookup user in database by e-mail
		UserDTO userExists = userService.findByEmail(userDTO.email);
		
		System.out.println(userExists);
		
		if (userExists != null) {
			return (ResponseEntity<String>)ResponseEntity.badRequest().header("Failure", "Cannot create User with existing Email-ID").body(new String("Error : Email-ID already exists !!!"));
		}
		else { // new user so we create user and send confirmation e-mail
//			User user = userService.toEntity(userDTO);
			// Disable user until they click on confirmation link in email
//		    userDTO.setIsEnabled(false);
		      
		    // Generate random 36-character string token for confirmation link
		    userDTO.confirmationToken = UUID.randomUUID().toString();
		        
		    UserDTO savedUser = userService.save(userDTO);
				
			String appUrl = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort();
			
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(userDTO.email);
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
					+ appUrl + "/pages/confirm?token=" + userDTO.confirmationToken);
			registrationEmail.setFrom("ajay.anand10@zoho.com");
			emailService.sendEmail(registrationEmail);
			String confirmationMessage = "A confirmation e-mail has been sent to " + savedUser.email;
			
			return (ResponseEntity<String>)ResponseEntity.created(new URI("/api/users/" + savedUser.id)).body(new String(confirmationMessage));
		}
			
	}
	
	// Process confirmation link
	@RequestMapping(value="/confirm", method = GET)
	public ResponseEntity<String> showConfirmationPage(@RequestParam("token") String token) {
			
		UserDTO user = userService.findByConfirmationToken(token);
			
		if (user == null) { // No token found in DB
			return ((BodyBuilder) ResponseEntity.notFound().header("Failure", "Invalid confirmation link")).body("Failure");
		} 
		else { // Token found
			
			if(user.isEnabled)
				return ResponseEntity.ok().header("Warning", "No need for multiple verifications").body(new String("Already Verified Before !!!"));
			user.isEnabled = true;
			userService.save(user);
			return ResponseEntity.ok().header("Success", "Correct confirmation link").body(new String("Success"));
		}
			
	}
	
	// Process confirmation link
	/*@RequestMapping(value="/confirm", method = POST)
	public ModelAndView processConfirmationForm(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map requestParams, RedirectAttributes redir) {
				
		modelAndView.setViewName("confirm");
		
		Zxcvbn passwordCheck = new Zxcvbn();
		
		Strength strength = passwordCheck.measure(requestParams.get("password"));
		
		if (strength.getScore() < 3) {
			bindingResult.reject("password");
			
			redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

			modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
			System.out.println(requestParams.get("token"));
			return modelAndView;
		}
	
		// Find the user associated with the reset token
		User user = userService.findByConfirmationToken(requestParams.get("token"));

		// Set new password
		user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

		// Set user to enabled
		user.setEnabled(true);
		
		// Save user
		userService.saveUser(user);
		
		modelAndView.addObject("successMessage", "Your password has been set!");
		return modelAndView;		
	}
*/
}
