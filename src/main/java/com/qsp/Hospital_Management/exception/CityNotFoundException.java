package com.qsp.Hospital_Management.exception;

public class CityNotFoundException extends RuntimeException {

  private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public CityNotFoundException(String message) {
		super();
		this.message = message;
	}
}
