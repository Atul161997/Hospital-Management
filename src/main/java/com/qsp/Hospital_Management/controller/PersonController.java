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

import com.qsp.Hospital_Management.dto.Perosn;
import com.qsp.Hospital_Management.service.PersonService;
import com.qsp.Hospital_Management.util.ResponseStructure;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	
	//1.Save
	@PostMapping
	public ResponseEntity<ResponseStructure<Perosn>> savePerson(@Valid @RequestBody Perosn perosn) {
		return personService.savePerson(perosn);      //@Valid all the exception for field validation come on front-end
	}
	
	//2.Find By Id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Perosn>> getPersonById(@PathVariable int id) {
		return personService.getPersonById(id);
	}
	
	//3. Find All
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Perosn>>> getAllPerson() {
		return personService.getAllPerson();
	}
	
	//4.Delete By Id
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Perosn>> deletePersonById(@RequestParam int id) {
		return personService.deletePersonById(id);
	}
	
	//5.Update All
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Perosn>> updatePerson(@RequestParam int id,@RequestBody Perosn perosn) {
		return personService.updatePerson(id,perosn);
	}
	
	//6.Find By Name
	@GetMapping("/name")
	public ResponseEntity<ResponseStructure<List<Perosn>>> getByName(@RequestParam String name) {
		return personService.getByname(name);
	}
	
	//7.Find By Email
	@GetMapping("/email/{email}")
	public ResponseEntity<ResponseStructure<Perosn>> getByEmail(@PathVariable String email) {
		return personService.getByEmail(email);
	}
	
	//8.Find By Phone
	@GetMapping("/phone")
	public ResponseEntity<ResponseStructure<Perosn>> getByPhone(@RequestParam long phone) {
		return personService.getByPhone(phone);
	}
	
	//9.Find By Address
	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<List<Perosn>>> getByAddress(@RequestParam String address) {
		return personService.getByAddress(address);
	}
	
	//10.Update Name
	@PatchMapping("/name")
	public ResponseEntity<ResponseStructure<Perosn>> updatePersonName(@RequestParam int id,@RequestParam String name) {
		return personService.updatePersonName(id,name);
	}
	
	//11.Update Phone
	@PatchMapping("/phone")
	public ResponseEntity<ResponseStructure<Perosn>> updatePersonPhone(@RequestParam int id,@RequestParam long phone) {
		return personService.updatePersonPhone(id,phone);
	}
	
	//12.Update Email
	@PatchMapping("/email")
	public ResponseEntity<ResponseStructure<Perosn>> updatePersonEmail(@RequestParam int id, @RequestParam String email) {
		return personService.updatePersonEmail(id, email);
	}
	
	//13.Update Addres
	@PatchMapping("/address")
	public ResponseEntity<ResponseStructure<Perosn>> updatePersonAddress(@RequestParam int id, @RequestParam String address) {
		return personService.updatePersonAddress(id,address);
	}
}
