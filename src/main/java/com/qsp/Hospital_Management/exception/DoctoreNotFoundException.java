package com.qsp.Hospital_Management.exception;

public class DoctoreNotFoundException extends RuntimeException{

    private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public DoctoreNotFoundException(String message) {
		super();
		this.message = message;
	}
}
