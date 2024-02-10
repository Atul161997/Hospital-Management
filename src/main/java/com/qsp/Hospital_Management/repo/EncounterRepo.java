package com.qsp.Hospital_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Hospital_Management.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer> {

	//4.Find Encounter By Cause
	List<Encounter> findEncounterByCause(String cause);
	
	//5.Find Encounter By Cost
	List<Encounter> findEncounterByCost(double cost);
}
