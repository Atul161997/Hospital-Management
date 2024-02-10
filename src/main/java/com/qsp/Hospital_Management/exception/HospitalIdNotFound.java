package com.qsp.Hospital_Management.exception;
//This For Handle null value/null data Custome Exception
public class HospitalIdNotFound extends RuntimeException{

	String message = "Hospital With Given Id Not Found";
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
