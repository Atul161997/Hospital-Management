package com.qsp.Hospital_Management.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Hospital_Management.dto.MedItems;
import com.qsp.Hospital_Management.dto.MedOrder;
import com.qsp.Hospital_Management.service.MedItemsService;
import com.qsp.Hospital_Management.util.ResponseStructure;


@RestController
@RequestMapping("/medItems")
public class MedItemsController {

	@Autowired
	private MedItemsService medItemsService;
	
	//1.Save
	@PostMapping
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@RequestBody MedItems medItems, @RequestParam int moid) {
		return medItemsService.saveMedItems(medItems,moid);
	}
	
	//2.Find By id
	@GetMapping
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(@RequestParam int id) {
		return medItemsService.getMedItemsById(id);
	}
	
	//3.Delete
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItemsById(@RequestParam int id) {
		return medItemsService.deleteMedItemsById(id);
	}
	
	//4.Update MedItems
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(@RequestParam int id, @RequestBody MedItems medItems) {
	   return medItemsService.updateMedItems(id,medItems);
	}
		
    //5.Find All MedItems
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<MedItems>>> getAllMedItems() {
		return medItemsService.getAllMedItems();
	}
		
	//6.Find MedItems By Name
	@GetMapping("/name")
	public ResponseEntity<ResponseStructure<List<MedItems>>> getMedItemsByName(@RequestParam String name) {
		return medItemsService.getMedItemsByName(name);
	}
		
}
