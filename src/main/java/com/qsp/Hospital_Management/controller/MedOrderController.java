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

import com.qsp.Hospital_Management.dto.MedOrder;
import com.qsp.Hospital_Management.service.MedOrderService;
import com.qsp.Hospital_Management.util.ResponseStructure;

@RestController
@RequestMapping("/medOrder")
public class MedOrderController {

	@Autowired
	private MedOrderService medOrderService;
	
	//1.Save
	@PostMapping
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medOrder ,@RequestParam int eid) {
		return medOrderService.saveMedOrder(medOrder,eid);
	}
	
	//2.Find By Id
	@GetMapping
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(@RequestParam int id) {
		return medOrderService.getMedOrderById(id);
	}
	
	//4.Delete MedOrder By Id
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrderById(@RequestParam int id) {
		return medOrderService.deleteMedOrderById(id);
	}
	
	//4.Update MedOrder
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestParam int id, @RequestBody MedOrder medOrder) {
		return medOrderService.updateMedOrder(id,medOrder);
	}
	
	//5.Find All MedOrder
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrder() {
		return medOrderService.getAllMedOrder();
	}
	
	//6.Find MedOrder By Doctor
	@GetMapping("/doctor")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getMedOrderByDoctor(@RequestParam String doctor) {
		return medOrderService.getMedOrderByDoctor(doctor);
	}
	
	//6.Find MedOrder By Date
	@GetMapping("/date")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getMedOrderByDate(@RequestParam Date date) {
		return medOrderService.getMedOrderByDate(date);
	}
}
