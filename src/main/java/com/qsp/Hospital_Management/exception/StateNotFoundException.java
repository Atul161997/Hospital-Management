package com.qsp.Hospital_Management.exception;

public class StateNotFoundException extends RuntimeException{

   private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public StateNotFoundException(String message) {
		super();
		this.message = message;
	}
}
