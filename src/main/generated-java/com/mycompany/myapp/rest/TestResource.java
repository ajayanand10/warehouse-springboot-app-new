package com.mycompany.myapp.rest;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.net.URISyntaxException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pages")
public class TestResource {
	
	private final Logger log = LoggerFactory.getLogger(TestResource.class);

	
	/**
	 * Find by id Warehouse.
	 */
     @RequestMapping(value = "/{name}", method = GET, produces = TEXT_PLAIN_VALUE)
     public ResponseEntity<String> findById(@PathVariable String name) throws URISyntaxException {

        log.debug("Accessing page without security : {}", name);
        String msg = "Hello, "+name+"!";

        return new ResponseEntity<>(msg,new HttpHeaders(),HttpStatus.OK);
    }
}
