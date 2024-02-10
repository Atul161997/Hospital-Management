package com.qsp.Hospital_Management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Data;
@Entity
@Data
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bId;
	
	@NotBlank(message = "Branch Name Can not be Blank")  // For Field validation we use this
	@NotNull(message = "Branch Name can not be null")   // For Field validation we use this
	private String name;
	
	@NotBlank(message = "Manager Name Can not be Blank")  // For Field validation we use this
	@NotNull(message = "Manager Name can not be null")   // For Field validation we use this
	private String manager;
	
	@ManyToOne
	private Hospital hospital;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Address address;
}
