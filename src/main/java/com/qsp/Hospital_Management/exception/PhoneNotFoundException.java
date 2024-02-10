package com.qsp.Hospital_Management.exception;

public class PhoneNotFoundException extends RuntimeException {

	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public PhoneNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
