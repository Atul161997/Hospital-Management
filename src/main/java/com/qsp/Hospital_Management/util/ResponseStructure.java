package com.qsp.Hospital_Management.util;

import lombok.Data;

@Data
public class ResponseStructure <T>{

	//This For All RESPONSE STRUCTURE FOR SERVER RESPONSE
	private String message;
	private int statusCode;
	private T data;
	
}
