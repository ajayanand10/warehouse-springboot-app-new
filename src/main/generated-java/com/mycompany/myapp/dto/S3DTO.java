package com.mycompany.myapp.dto;

/**
 * Simple DTO for Files from AWS S3.
 */
public class S3DTO {
	
	public String bucket;
	public String srcFilePath;//fully qualified file with extension and the folder in which it is present
	public String destFilePath;//path after bucket where the file needs to be uploaded in S3
	public String downloadKey;
	public String uploadKey;//uploaded file name with file type
	
}
