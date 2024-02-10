package com.qsp.Hospital_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Hospital_Management.dto.MedItems;

public interface MedItemsRepo extends JpaRepository<MedItems, Integer> {

	
	//6.Find By name
	List<MedItems> findMedItemsByName(String name);
}
