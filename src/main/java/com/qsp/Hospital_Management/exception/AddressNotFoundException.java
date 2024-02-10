package com.qsp.Hospital_Management.exception;

public class AddressNotFoundException extends RuntimeException{

private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public AddressNotFoundException(String message) {
		super();
		this.message = message;
	}
}
