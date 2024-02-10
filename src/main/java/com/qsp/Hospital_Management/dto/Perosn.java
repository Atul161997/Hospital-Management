package com.qsp.Hospital_Management.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Perosn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;
	
	@NotBlank(message = "Person Name Can not be Blank")  // For Field validation we use this
	@NotNull(message = "Person Name can not be null")   // For Field validation we use this
	private String name;
	
	@Column(unique = true)
	@Min(value = 6000000000l)
	@Max(value = 9999999999l) //phone number validation
	private long phone;
	
	@Column(unique = true)
	@NotBlank(message = "Email Can not be Blank")  // For Field validation we use this
	@NotNull(message = "Email can not be null")   // For Field validation we use this
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9]+\\.[a-z]{2,3}",message = "Invalid Email Addres Format") //Email validation
	private String email;
	
	@NotBlank(message = "Person Address Can not be Blank")  // For Field validation we use this
	@NotNull(message = "Person Address can not be null")   // For Field validation we use this
	private String address;
	
}
