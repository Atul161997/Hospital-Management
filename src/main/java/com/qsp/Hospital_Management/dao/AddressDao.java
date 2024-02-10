package com.qsp.Hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Hospital_Management.dto.Address;
import com.qsp.Hospital_Management.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo addressRepo;
	
	//1.Save Address
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}

	//2. Find By Id
	public Address findAddressById(int id) {
		Optional<Address> optional = addressRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	//3. Find All
	public List<Address> getAllAddree() {
		return addressRepo.findAll();
	}

	//4. Delete By Id
	public Address deleteAddress(int id) {
		Optional<Address> optional=addressRepo.findById(id);
		if (optional.isPresent()) {
			Address address = optional.get();
		    addressRepo.delete(address);
		    return address;
		}
		return null;
	}

	//5. Update All
	public Address updateAddress(int id, Address address) {
		Optional<Address> optional=addressRepo.findById(id);
		if(optional.isPresent())
		{
			address.setAId(id);
			return addressRepo.save(address);
		}
		return null;
	}

	//6.Update City
	public Address updateCity(int id, String city) {
	    Optional<Address>optional=addressRepo.findById(id);
	    if (optional.isPresent()) {
	    	Address dbAddress=optional.get();
	    	dbAddress.setCity(city);
	    	return addressRepo.save(dbAddress);	
		}
		return null;
	}

	//7.Update State
	public Address updateState(int id, String state) {
        Optional<Address> optional=addressRepo.findById(id);
        if (optional.isEmpty()) {
        	return null;
		}
        Address dbAddress=optional.get();
        dbAddress.setState(state);
        return addressRepo.save(dbAddress);
		
	}

	//8.Update Pincode
	public Address updatePincode(int id, int pincode) {
		 Optional<Address> optional=addressRepo.findById(id);
	        if (optional.isEmpty()) {
	        	return null;
			}
	        Address dbAddress=optional.get();
	        dbAddress.setPincode(pincode);
	        return addressRepo.save(dbAddress);
	}
	

	//9. Find By Pincode
	public Address getAddressByPinCode(int pincode) {
		return addressRepo.findAddressByPincode(pincode);
	}

	//10. Find By City
	public List<Address> getAddressByCity(String city) {
		return addressRepo.findAddressByCity(city);
	}

	//11.Find By State
	public List<Address> getAddressByState(String state) {
		return addressRepo.findAddressByState(state);
	}

}
