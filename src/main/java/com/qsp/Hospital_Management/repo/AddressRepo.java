package com.qsp.Hospital_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Hospital_Management.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	//9. Find By Pincode
	Address findAddressByPincode(int pincode);
	
	//10.Find By City
	List<Address> findAddressByCity(String city);
	
	//11.Find By City
	List<Address> findAddressByState(String state);
	
	
}
