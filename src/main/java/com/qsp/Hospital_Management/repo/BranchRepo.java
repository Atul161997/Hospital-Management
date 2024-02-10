package com.qsp.Hospital_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.dto.Hospital;

public interface BranchRepo extends JpaRepository<Branch, Integer> {

	//5.
	List<Branch> findBrancheByManager(String manager);
		
	//10.
	List<Branch> findBranchByName(String name);
		
	//11. Find Branches By Hospital
	List<Branch> findBranchesByHospital(Hospital dbHospital);

	// Find Branches By Hospital Name
	//@Query("SELECT b FROM Branch b WHERE b.hospital.name=?1")
	//List<Branch> findBranchesByHospitalName(Hospital hospital);
	
	
}
