package com.uebercomputing.aws;

import java.io.File;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * Do: aws configure
 * ~/.aws/conf
 * output = json
 * region = us-east-1
 * 
 * ~/.aws/credentials
 * aws_access_key_id=
 * aws_secret_access_key=
 * 
 * aws s3 mb s3://$SLPR_CELL_BUCKET (Note: Bucket name must be globally unique! Adjust below)
 * 
 * Run with args: damage damage
 * 
 * Verify upload: aws s3 cp s3://SLPRCELL/damage d1
 * 
 * ProfileCredentialsProvider:
 * 
 * Checks ~/.aws/credentials
 */
public class S3Uploader {

	private static final String SLPR_CELL_BUCKET = "SLPRCELL";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		checkArgs(args);
		String key = args[0];
		String fileName = args[1];
		AmazonS3 s3Client = new AmazonS3Client(new ProfileCredentialsProvider());
		try {
			File file = new File(fileName);
			s3Client.putObject(new PutObjectRequest(SLPR_CELL_BUCKET, key, file));
		} catch (AmazonServiceException serviceEx) {
			System.out.println(serviceEx);
		} catch (AmazonClientException clientEx) {
			System.out.println(clientEx);
		}
	}
	
	public static void checkArgs(String[] args) {
		if (args.length != 2) {
			String errMsg = "Expected two arguments: key, file";
			throw new IllegalArgumentException(errMsg);
		}
	}

}