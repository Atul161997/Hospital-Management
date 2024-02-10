package com.qsp.Hospital_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.Hospital_Management.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer>{

	//5.Find By Email
	Hospital findHospitalByEmail(String email);
	
	//6.Find By Name
	List<Hospital> findHospitalByName(String name);
	
	//
	Hospital findHospitalsByName(String name);
	
	//7.Find By CEO
	List<Hospital> findHospitalByCeo(String ceo);
	
	//Find All
	@Query("SELECT h FROM Hospital h")
	List<Hospital> getAllHospital();
}
