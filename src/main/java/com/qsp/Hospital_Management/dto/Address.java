package com.qsp.Hospital_Management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aId;
	
	@NotBlank(message = "City Name Can not be Blank")  // For Field validation we use this
	@NotNull(message = "City Name can not be null")   // For Field validation we use this
	private String city;
	
	@NotBlank(message = "State Name Can not be Blank")  // For Field validation we use this
	@NotNull(message = "State Name can not be null")   // For Field validation we use this
	private String state;
	
	
	private int pincode;
}
