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

import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.service.BranchService;
import com.qsp.Hospital_Management.util.ResponseStructure;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	//1. Save 
	@PostMapping
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid @RequestParam int hId,@RequestParam  int aId,@RequestBody Branch branch) {
		return branchService.saveBranch(hId,aId,branch);
	}
	
	//2. Find By Id
	@GetMapping("/getById")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@RequestParam int bId) {
		return branchService.getBranchById(bId);
	}
	
	//3. Find All
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranches() {
		return branchService.getAllBranches();
	}
	
	//4.Delete By Id
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Branch>> deleteById(@RequestParam int id) {
		return branchService.deleteById(id);
	}
	
	//5.Find Brnaches By Manager 
	@GetMapping("/manager")
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchesByManager(@RequestParam String manager) {
		return branchService.getBranchesByManager(manager);
	}
	
	//6.Update All
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchOnly(@RequestParam int id, @RequestBody Branch branch) {
		return branchService.updateBranchOnly(id, branch);
	}
	
	// 7. Update Manager
	@PatchMapping("/manager")
	public ResponseEntity<ResponseStructure<Branch>> updateManager(@RequestParam int id, @RequestParam String manager) {
		return branchService.updateManager(id, manager);
	}
	
	// 8. Update Branch Name
	@PatchMapping("/name")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchName(@RequestParam int id, @RequestParam String name) {
		return branchService.updateBranchName(id, name);
	}
	// 9. Update Branch / Address / Hospital
	@PutMapping("/updateAll")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int id, @RequestParam int hid, @RequestParam int aid, @RequestBody Branch branch) {
		return branchService.updateBranch(id, hid, aid, branch);
	}
	
	//10.Find Branch By Name
	@GetMapping("/name")
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByName( @RequestParam String name) {
		return branchService.getBranchByName(name);
	}
	
	//11. Find Branches By Hospital
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchesByHospital(@RequestParam int hId) {
		return branchService.findBranchesByHospital(hId);
	}
	
	// Find Branches By Hospital Name ERROR
//	@GetMapping("/name")
//	public List<Branch> findBranchesByHospitalName(@RequestParam String name) {
//		return branchService.findBranchesByHospitalName(name);
//	}
	
	
}
