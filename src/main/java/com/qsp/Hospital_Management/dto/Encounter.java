package com.qsp.Hospital_Management.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Data;

@Entity
@Data
public class Encounter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eId;
	
	@NotBlank(message = "Cause Can not be Blank")  // For Field validation we use this
	@NotNull(message = "Cause Name can not be null")   // For Field validation we use this
	private String cause;
	
	private double cost;
	
	
	@ManyToOne
	private Perosn  perosn;
	
	@OneToMany
	private List<Branch> branchs;

}
