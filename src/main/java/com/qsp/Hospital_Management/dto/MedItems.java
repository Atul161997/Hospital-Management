package com.qsp.Hospital_Management.dto;

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
public class MedItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mId;
	
	@NotBlank(message = "MedItem Name Can not be Blank")  // For Field validation we use this
	@NotNull(message = "MedItem Name can not be null")   // For Field validation we use this
	private String name;
	
	private double price;
	
	@ManyToOne
	private MedOrder medOrder;
}
