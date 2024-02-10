package com.qsp.Hospital_Management.exception;

public class DateNotFoundException extends RuntimeException{

	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public DateNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
