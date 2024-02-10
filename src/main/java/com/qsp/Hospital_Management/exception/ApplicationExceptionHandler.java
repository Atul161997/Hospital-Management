package com.qsp.Hospital_Management.exception;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.Hospital_Management.util.ResponseStructure;

@RestControllerAdvice  // for controller come here to check exception hanle or not Act Like Catch block
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	
	//1.IdNoTFoundException
	@ExceptionHandler(IdNoTFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNoTFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		
		responseStructure.setMessage("ID_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	
	//2.NameNotFoundException
	@ExceptionHandler(NameNotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> nameNotFoundExceptionHandler(NameNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		
		responseStructure.setMessage("NAME_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	//3.EmailNotFoundException
	@ExceptionHandler(EmailNotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> emailNotFoundExceptionHandler(EmailNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
			
		responseStructure.setMessage("EMAIL_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
			
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	//4.CEONotFoundException
	@ExceptionHandler(CEONotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> ceoNotFoundExceptionHandler(CEONotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
				
		responseStructure.setMessage("CEO_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
				
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	//5.AddressNotFoundException
	@ExceptionHandler(AddressNotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> addressNotFoundExceptionHandler(AddressNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
					
		responseStructure.setMessage("ADDRESS_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
					
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	//6.PhoneNotFoundException
	@ExceptionHandler(PhoneNotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> phoneNotFoundExceptionHandler(PhoneNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
						
		responseStructure.setMessage("PHONE_NUMBER_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
						
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	//7.CityNotFoundException
	@ExceptionHandler(CityNotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> cityNotFoundExceptionHandler(CityNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
							
		responseStructure.setMessage("CITY_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
							
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	//8.StateNotFoundException
	@ExceptionHandler(StateNotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> stateNotFoundExceptionHandler(StateNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
								
		responseStructure.setMessage("STATE_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
								
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	//9.PincodeNotFoundException
	@ExceptionHandler(PincodeNotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> pincodeNotFoundExceptionHandler(PincodeNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
									
		responseStructure.setMessage("PINCODE_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
									
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	

	//10.ManagerNotFoundException
	@ExceptionHandler(ManagerNotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> managerNotFoundExceptionHandler(ManagerNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
									
		responseStructure.setMessage("MANAGER_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
									
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	

	//11.CauseNotFoundException
	@ExceptionHandler(CauseNotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> CauseNotFoundExceptionHandler(CauseNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
									
		responseStructure.setMessage("CAUSE_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
									
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	//12.DoctoreNotFoundException
	@ExceptionHandler(DoctoreNotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> doctorNotFoundExceptionHandler(DoctoreNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
										
		responseStructure.setMessage("Dr.BHARAT_KALE_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
										
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	//13.CostNotFoundException
	@ExceptionHandler(CostNotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> costNotFoundExceptionHandler(CostNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
										
		responseStructure.setMessage("COST_KALE_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
										
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	//13.DateNotFoundException
	@ExceptionHandler(DateNotFoundException.class)  // This annotation is used for to handle exception for class
	public ResponseEntity<ResponseStructure<String>> dateNotFoundExceptionHandler(DateNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
											
		responseStructure.setMessage("DATE_KALE_NOT_FOUND_EXCEPTION");
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
											
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
    //For Handle Filed Validation Exception And Take all Exception in front-end OutPut i.e POSTMAN
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
		
		List<ObjectError> liErrors = ex.getAllErrors(); // For Get All Erro/Exception because of field validation
		
		Map<String, String> map = new HashMap<>();  // For Key and value  [JSON Object data response]
		
		for( ObjectError objectError: liErrors)  // Best way to iterate collection
		{
			FieldError fieldError = (FieldError) objectError;  // Down cast OjectError to FieldError. ---> OjectError is Super Class
			String name = fieldError.getField();  //get data
			String message = fieldError.getDefaultMessage(); //get data from inbulid method
			
			map.put(name, message);  // add data into map
		}
		
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);  // return all exception
	}
}
