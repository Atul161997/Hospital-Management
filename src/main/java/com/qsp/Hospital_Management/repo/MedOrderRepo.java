package com.qsp.Hospital_Management.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Hospital_Management.dto.MedOrder;

public interface MedOrderRepo extends JpaRepository<MedOrder, Integer> {

	//6.Find By Doctor
	List<MedOrder> findMedOrderByDoctor(String Doctor);
	
	//7.Find by Date
	List<MedOrder> findMedOrderByDate(Date date);
}
