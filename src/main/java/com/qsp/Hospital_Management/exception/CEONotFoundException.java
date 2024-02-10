package com.qsp.Hospital_Management.exception;

public class CEONotFoundException extends RuntimeException{

	   private String message;
		
		@Override
		public String getMessage() {
			return message;
		}

		public CEONotFoundException(String message) {
			super();
			this.message = message;
		}
}
