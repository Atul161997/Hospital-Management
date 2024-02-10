package com.qsp.Hospital_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qsp.Hospital_Management.dto.Perosn;

public interface PersonRepo extends JpaRepository<Perosn, Integer> {

	//6.Find By Name
	List<Perosn> findPersonByName(String name);
	
	//7.Find By Email
	Perosn findPersonByEmail(String email);
	
	//8.Fin by Phone
	Perosn findPersonByPhone(long phone);
	
	//9.Find By Address
	List<Perosn> findPersonByAddress(String address);
}
