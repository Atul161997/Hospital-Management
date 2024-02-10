package com.qsp.Hospital_Management.exception;

public class CauseNotFoundException extends RuntimeException{

	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public CauseNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
