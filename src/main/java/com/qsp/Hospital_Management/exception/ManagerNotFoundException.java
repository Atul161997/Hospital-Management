package com.qsp.Hospital_Management.exception;

public class ManagerNotFoundException extends RuntimeException{

	
   private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public ManagerNotFoundException(String message) {
		super();
		this.message = message;
	}
}
