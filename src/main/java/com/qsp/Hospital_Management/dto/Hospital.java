package com.qsp.Hospital_Management.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hId;
	
	@NotBlank(message = "Hospital Name Can not be Blank")  // For Field validation we use this
	@NotNull(message = "Hospital Name can not be null")   // For Field validation we use this
	private String name;
	
	@Column(unique = true)
	@NotBlank(message = "Email Can not be Blank")  // For Field validation we use this
	@NotNull(message = "Email can not be null")   // For Field validation we use this
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9]+\\.[a-z]{2,3}",message = "Invalid Email Addres Format") // @Parameter For Email Validation
	private String email;
	
	@NotBlank(message = "CEO Name Can not be Blank")  // For Field validation we use this
	@NotNull(message = "CEO Name can not be null")   // For Field validation we use this
	private String ceo;
}
