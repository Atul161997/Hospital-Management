package com.qsp.Hospital_Management.exception;

public class EmailNotFoundException extends RuntimeException{

	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public EmailNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
	
}
