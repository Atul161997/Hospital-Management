package com.qsp.Hospital_Management.exception;

public class IdNoTFoundException extends RuntimeException {

	private String message;
	
	// getMessage() and printSatck() methods of throwable class
	@Override
	public String getMessage() {
		return message;
	}

	public IdNoTFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
