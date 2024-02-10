package com.qsp.Hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.dto.Hospital;
import com.qsp.Hospital_Management.repo.BranchRepo;

@Repository
public class BranchDao {
	
	@Autowired
	private BranchRepo branchRepo;

	//1.Save
	public Branch saveBranch(Branch branch) {	
		return branchRepo.save(branch);
	}


	//2.Find By Id
	public Branch getBranchById(int bId) {
		 Optional<Branch> optional=branchRepo.findById(bId);
		 if (optional.isPresent()) {
			  return optional.get();
		}
		 return null;
	}

	//3.Find All Branches
	public List<Branch> getAllBranches() {
		return branchRepo.findAll();
	}

	//4.Delete By Id
	public Branch deleteById(int id) {
		Optional<Branch>optional=branchRepo.findById(id);
		if (optional.isPresent()) {
			branchRepo.deleteById(id);
			return optional.get();
		}
		return null;
	}

	//5. Find Branches by manager
	public List<Branch> getBranchesByManager(String manager) {
		return branchRepo.findBrancheByManager(manager);
	}
	
	//6.
	public Branch updateBranchOnly(int id, Branch branch) {
		Optional<Branch> optional = branchRepo.findById(id);
		if (optional.isPresent()) {
			branch.setBId(id);
			branch.setHospital(optional.get().getHospital());
			branch.setAddress(optional.get().getAddress());
			return branchRepo.save(branch);
		 }
		  return null;
	}

	//7.
	public Branch updateManager(int id, String manager) {
	  Optional<Branch> optional = branchRepo.findById(id);
	  if (optional.isEmpty()) {
		return null;
	   }
	  Branch branch = optional.get();
	  branch.setManager(manager);
	  return branchRepo.save(branch);
	}


	//8.
	public Branch updateBranchNamer(int id, String name) {
		Optional<Branch> optional = branchRepo.findById(id);
		  if (optional.isEmpty()) {
			return null;
		   }
		  Branch branch = optional.get();
		  branch.setName(name);
		  return branchRepo.save(branch);
	}
	
	//9.
	public Branch updateBranch(int id, Branch branch) {
		Optional<Branch> optional = branchRepo.findById(id);
		if (optional.isPresent()) {
			branch.setBId(id);
			return branchRepo.save(branch);
		 }
		  return null;
	}
	
	//10.Find Branch By name
	public List<Branch> getBranchByName(String name) {
		return branchRepo.findBranchByName(name);
	}
	
	//11. Find Branches By Hospital
	public List<Branch> findBranchesByHospital(Hospital dbHospital) {
		return branchRepo.findBranchesByHospital(dbHospital);
	}
	
//	// Find Branches By Hospital Name
//	public List<Branch> findBranchesByHospitalName(Hospital hospital) {
//		return branchRepo.findBranchesByHospitalName(hospital);
//	}

}
