package com.qsp.Hospital_Management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Hospital_Management.dto.Address;
import com.qsp.Hospital_Management.service.AddressService;
import com.qsp.Hospital_Management.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	
	//1. Save Address
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid  @RequestBody  Address address) {
		return addressService.saveAddress(address);
	}
	
	//2. Find By Id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Address>> findAddressById(@PathVariable  int id) {
		return addressService.findAddressById(id);
	}
	
	//3. Find All
	@GetMapping("/getAll")
	public ResponseEntity<ResponseStructure<List<Address>>> getAllAddree() {
		return addressService.getAllAddree();
	}
	
	//4. Delete By Id      Note:- Some Address Which Mapped With Branch then we can not delete because Address Is NON-OWNING Side
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteById(@RequestParam  int id) {
		return addressService.deleteById(id);
	}
	
	//5. Update All
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int id, @RequestBody Address address) {
		return addressService.updateAddress(id,address);
	}
	
	//6. Update City
	@PatchMapping("/city")
	public ResponseEntity<ResponseStructure<Address>> updateCity(@RequestParam int id,@RequestParam String city) {
		return addressService.updateCity(id,city);
	}
	
	//7.Update State
	@PatchMapping("/state")
	public ResponseEntity<ResponseStructure<Address>> updateState(int id, String state) {
		return addressService.updateState(id,state);
	}
	
	
	//8.Update Pincode
	@PatchMapping("/pincode")
	public ResponseEntity<ResponseStructure<Address>> updatePincode(@RequestParam int id ,@RequestParam int pincode) {
		return addressService.updatePincode(id,pincode);
	}
	
	//9. Find By Pincode
	@GetMapping("/getByPincode")
	public ResponseEntity<ResponseStructure<Address>> getAddressByPinCode(@RequestParam int pincode) {
		return addressService.getAddressByPinCode(pincode);
	}
	
	//10. Find By City
	@GetMapping("/getByCity")
	public ResponseEntity<ResponseStructure<List<Address>>> getAddressByCity(@RequestParam String city){
		return addressService.getAddressByCity(city);
	}
	
	//11.Find By State
	@GetMapping("/getByState")
	public ResponseEntity<ResponseStructure<List<Address>>> getAddressByState(@RequestParam String state) {
		return addressService.getAddressByState(state);
	}
	
}
