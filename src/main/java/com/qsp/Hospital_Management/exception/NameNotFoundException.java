package com.qsp.Hospital_Management.exception;

public class NameNotFoundException extends RuntimeException {

	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public NameNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
