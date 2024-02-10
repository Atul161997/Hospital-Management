package com.qsp.Hospital_Management.exception;

public class CostNotFoundException extends RuntimeException {

	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public CostNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
