package com.qsp.Hospital_Management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.qsp.Hospital_Management.dto.Hospital;
import com.qsp.Hospital_Management.service.HospitalService;
import com.qsp.Hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital") // Calss level annotation
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	// 1.SAVE
	@ApiOperation(notes = "This API is use to save the Hospital Details into the Database",value = "Save Hospital API") //This is for change API info Datils in Swagger Documentation
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Data Save Successfully.")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}

	// 2.GET
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@PathVariable int id) {
		return hospitalService.getHospitalById(id);
	}

	// 3.DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(@PathVariable int id) {
		return hospitalService.deleteHospitalById(id);
	}

	// 4.Get all
	@GetMapping("/getAll")
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital() {
		return hospitalService.getAllHospital();
	}

	// 5.Get By Email
	@GetMapping("/findByEmail")
	public ResponseEntity<ResponseStructure<Hospital>> getByEmail(@RequestParam String email) {
		return hospitalService.getByEmail(email);
	}

	// 6.Get By Name
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Hospital>>> getByName(@RequestParam String name) {
		return hospitalService.getByName(name);
	}

	//
	@GetMapping("/name")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByName(@RequestParam String name) {
		return hospitalService.getHospitalByName(name);
	}

	// 7.Get By CEO
	@GetMapping("/getByCEO")
	public ResponseEntity<ResponseStructure<List<Hospital>>> getByCEO(@RequestParam String ceo) {
		return hospitalService.getByCEO(ceo);
	}

	// 8.Update all
	@PutMapping
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(@RequestParam int id, @RequestBody Hospital hospital) {
		return hospitalService.updateHospitalById(id, hospital);
	}

	// 9.Update Hospital Name
	@PatchMapping("/name")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalName(@RequestParam int id, @RequestParam String name) {
		return hospitalService.updateHospitalName(id, name);
	}

	// 10. Update Hospital Email
	@PatchMapping("/email")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalEmail(@RequestParam int id, @RequestParam String email) {
		return hospitalService.updateHospitalEmail(id, email);
	}

	// 11.Update Hospital CEO
	@PatchMapping("/ceo")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalCeo(int id, String ceo) {
		return hospitalService.upadteHospitalCeo(id, ceo);
	}
}
