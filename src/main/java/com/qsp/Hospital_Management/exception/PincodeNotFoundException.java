package com.qsp.Hospital_Management.exception;

public class PincodeNotFoundException extends RuntimeException{

  private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public PincodeNotFoundException(String message) {
		super();
		this.message = message;
	}
}
