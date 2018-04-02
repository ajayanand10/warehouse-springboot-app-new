package com.mycompany.myapp.rest;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.dto.S3DTO;
import com.mycompany.myapp.dto.S3Service;

@RestController
@RequestMapping("/pages/s3")
public class S3Resource {
	
	@Autowired
	S3Service s3Service;
	
	
	@RequestMapping(value = "/upload", method = POST, produces = TEXT_PLAIN_VALUE)
	public ResponseEntity<String> uploadFile(@RequestBody S3DTO s3DTO) throws URISyntaxException {
		
		s3Service.uploadFile(s3DTO);
		
		return ((BodyBuilder)ResponseEntity.created(new URI(s3Service.getBucketName()+"/"+s3DTO.destFilePath+"/"+s3DTO.uploadKey))).body("File uploaded successfully !!!");
		
	}

}
