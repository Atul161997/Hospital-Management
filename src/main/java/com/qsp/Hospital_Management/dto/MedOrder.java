package com.qsp.Hospital_Management.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int moId;
	private Date date;
	
	@NotBlank(message = "Doctor Name Can not be Blank")  // For Field validation we use this
	@NotNull(message = "Doctor Name can not be null")   // For Field validation we use this
	private String doctor;
	
	@ManyToOne
	private Encounter encounter;
		
	
}
