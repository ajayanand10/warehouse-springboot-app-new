/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Source code: https://github.com/jaxio/celerio/
 * Follow us on twitter: @jaxiosoft
 * This header can be customized in Celerio conf...
 * Template pack-angular:src/main/java/rest/EntityResource.java.e.vm
 */
package com.mycompany.myapp.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.dto.UserDTO;
import com.mycompany.myapp.dto.UserDTOService;
import com.mycompany.myapp.dto.support.PageRequestByExample;
import com.mycompany.myapp.dto.support.PageResponse;
import com.mycompany.myapp.repository.UserRepository;
import com.mycompany.myapp.rest.support.AutoCompleteQuery;

@RestController
@RequestMapping("/pages")
public class UserRegistrationResource {

    private final Logger log = LoggerFactory.getLogger(UserRegistrationResource.class);

    @Inject
    private UserRepository userRepository;
    @Inject
    private UserDTOService userDTOService;

    /**
     * Create a new User.
     */
    @RequestMapping(value = "/register", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) throws URISyntaxException {

        log.debug("Create New User : {}", userDTO);

        /*if (userDTO.isIdSet()) {
            return ResponseEntity.badRequest().header("Failure", "Cannot create User with existing ID").body(null);
        }
        
        // Lookup user in database by e-mail
 		User userExists = userDTOService.findByEmail(userDTO.email);
 		if (userExists != null) {
 			return ResponseEntity.badRequest().header("Failure", "Cannot create User with existing EmailId").body(null);
 		}
 		else { // new user so we create user and send confirmation e-mail
				
 			// Disable user until they click on confirmation link in email
 		    userDTO.isEnabled=false;
 		      
 		    // Generate random 36-character string token for confirmation link
 		    userDTO.confirmationToken=UUID.randomUUID().toString());
 		        
 		    userDTOService.saveUser(user);
 				
		String appUrl = request.getScheme() + "://" + request.getServerName();
 			
 			SimpleMailMessage registrationEmail = new SimpleMailMessage();
 			registrationEmail.setTo(userDTO.email());
 			registrationEmail.setSubject("Registration Confirmation");
 			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
 					+ appUrl + "/confirm?token=" + user.getConfirmationToken());
 			registrationEmail.setFrom("noreply@domain.com");
 			
 			emailService.sendEmail(registrationEmail);
 			
 			modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
 			modelAndView.setViewName("register");
 		}

        UserDTO result = userDTOService.save(userDTO);

        return ResponseEntity.created(new URI("/api/users/" + result.id)).body(result);
        
        	
     		
     		
     		
     		if (userExists != null) {
     			modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
     			modelAndView.setViewName("register");
     			bindingResult.reject("email");
     		}
     			
     		if (bindingResult.hasErrors()) { 
     			modelAndView.setViewName("register");		
     		} 
     			
     		return modelAndView;*/
        return ResponseEntity.ok().body(null);
    }

    /**
    * Find by id User.
    */
    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Find by id User : {}", id);

        return Optional.ofNullable(userDTOService.findOne(id)).map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update User.
     */
    @RequestMapping(value = "/", method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) throws URISyntaxException {

        log.debug("Update UserDTO : {}", userDTO);

        if (!userDTO.isIdSet()) {
            return create(userDTO);
        }

        UserDTO result = userDTOService.save(userDTO);

        return ResponseEntity.ok().body(result);
    }

    /**
     * Find a Page of User using query by example.
     */
    @RequestMapping(value = "/page", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResponse<UserDTO>> findAll(@RequestBody PageRequestByExample<UserDTO> prbe) throws URISyntaxException {
        PageResponse<UserDTO> pageResponse = userDTOService.findAll(prbe);
        return new ResponseEntity<>(pageResponse, new HttpHeaders(), HttpStatus.OK);
    }

    /**
    * Auto complete support.
    */
    @RequestMapping(value = "/complete", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> complete(@RequestBody AutoCompleteQuery acq) throws URISyntaxException {

        List<UserDTO> results = userDTOService.complete(acq.query, acq.maxResults);

        return new ResponseEntity<>(results, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Delete by id User.
     */
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Delete by id User : {}", id);

        try {
            userRepository.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception x) {
            // todo: dig exception, most likely org.hibernate.exception.ConstraintViolationException
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}