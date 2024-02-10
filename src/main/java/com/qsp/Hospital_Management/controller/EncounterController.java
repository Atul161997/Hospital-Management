package com.qsp.Hospital_Management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Hospital_Management.dto.Encounter;
import com.qsp.Hospital_Management.service.EncounterService;
import com.qsp.Hospital_Management.util.ResponseStructure;

@RestController
@RequestMapping("/encounter")
public class EncounterController {

	@Autowired
	private EncounterService encounterService;
	
	//1.Save
	@PostMapping
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter( @Valid @RequestBody Encounter encounter, @RequestParam int pid, @RequestParam int bid) {
		return encounterService.saveEncounter(encounter,pid,bid);
	}
	
	//2.Find Encounter By Id
	@GetMapping
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@RequestParam int id) {
		return encounterService.getEncounterById(id);
	}
	
	//3.Find All Encounter
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Encounter>>> getAllEncounter() {
		return encounterService.getAllEncounter();
	}
	
	//4.Find Encounter By cause
	@GetMapping("/cause")
	public ResponseEntity<ResponseStructure<List<Encounter>>> getEncounterByCasue(@RequestParam String cause) {
		return encounterService.getEncounterByCasue(cause);
	}
	
	//5.Find Encounter By Cost
	@GetMapping("/cost")
	public ResponseEntity<ResponseStructure<List<Encounter>>> getEncounterByCost(@RequestParam double cost) {
		return encounterService.getEncounterByCost(cost);
	}
	
	//6.update Encounter  
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter( @RequestParam int id,@RequestBody Encounter encounter) {
		return encounterService.updateEncounter(id,encounter);
	}
	
	//7. Delete Encounter 
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int id) {
		return encounterService.deleteEncounter(id);
	}
	
	//8.Update encounter Cause
	@PatchMapping("/cause")
	public ResponseEntity<ResponseStructure<Encounter>> updateCause(@RequestParam int id, @RequestParam String cause) {
		return encounterService.updateCause(id,cause);
	}
	
	//9.Update Encounter Cost
	@PatchMapping("/cost")
	public ResponseEntity<ResponseStructure<Encounter>> updateCost(@RequestParam int id, @RequestParam double cost) {
		return encounterService.updateCost(id,cost);
	}
}
