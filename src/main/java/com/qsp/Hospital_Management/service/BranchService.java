package com.qsp.Hospital_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.AddressDao;
import com.qsp.Hospital_Management.dao.BranchDao;
import com.qsp.Hospital_Management.dao.HospitalDao;
import com.qsp.Hospital_Management.dto.Address;
import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.dto.Hospital;
import com.qsp.Hospital_Management.dto.Perosn;
import com.qsp.Hospital_Management.exception.IdNoTFoundException;
import com.qsp.Hospital_Management.exception.ManagerNotFoundException;
import com.qsp.Hospital_Management.exception.NameNotFoundException;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private AddressDao addressDao;

	ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
	
	//1.Save
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(int hId, int aId, Branch branch) {
		Hospital dbHospital = hospitalDao.getHospitalById(hId);
		Address dbAddress =addressDao.findAddressById(aId);
	
		if (dbHospital!=null && dbAddress!=null) {
			branch.setHospital(dbHospital);
			branch.setAddress(dbAddress);
			//return branchDao.saveBranch(branch);	
			Branch branch2 = branchDao.saveBranch(branch);
			responseStructure.setMessage("Branch Saved Successfully..!");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(branchDao.saveBranch(branch2));
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
			
		}
		return null;
	}

	//2.Find By Id
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int bId) {
		//return branchDao.getBranchById(bId);
		Branch branch = branchDao.getBranchById(bId);
		
		if (branch!= null) {
			responseStructure.setMessage("Branch Found Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(branchDao.getBranchById(bId));
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		} else {
			//responseStructure.setMessage("Branch Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(branchDao.getBranchById(bId));
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Branch Data Not Found For Given Branch Id.");
			
		}
	}

	//3.Find all Branches
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranches() {
		//return branchDao.getAllBranches();
		ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<>();
		List<Branch> branchs = branchDao.getAllBranches();
		
		if (branchs.isEmpty()) {
			responseStructure.setMessage("Branches Not Found..!");
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(branchs);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.NOT_FOUND);
		}
		responseStructure.setMessage("Branch Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(branchs);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.FOUND);
	}

	//4.Delete Branch By Id
	public ResponseEntity<ResponseStructure<Branch>> deleteById(int id) {
		//return branchDao.deleteById(id);
		Branch branch=branchDao.deleteById(id);
		if (branch!= null) {
			responseStructure.setMessage("Branch Deleted Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branch);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Branch Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(branch);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Branch Data Not Found For Given Branch Id.");
		}
	}

	//5.Find Branches By Manager
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchesByManager(String manager) {
		//return branchDao.getBranchesByManager(manager);
		ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<>();
		List<Branch> branchs = branchDao.getBranchesByManager(manager);
		
		if (branchs.isEmpty()) {
			//responseStructure.setMessage("Branches Data Not Found For Given Manager..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(branchs);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new ManagerNotFoundException("Branch Data Not Found For Given Branch Manager.");
		}
		responseStructure.setMessage("Branch Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(branchs);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.FOUND);
	}
	
	//6.Update Branch
	public ResponseEntity<ResponseStructure<Branch>> updateBranchOnly(int id, Branch branch) {
		Branch dbBranch = branchDao.updateBranchOnly(id, branch);
		if (dbBranch !=null) {
			responseStructure.setMessage("Branch Updated Successfully");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(dbBranch);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Branch>>(HttpStatus.OK);
			
		} else {
			//responseStructure.setMessage("Branch Not Found");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(dbBranch);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Branch>>(HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Branch Data Not Found For Given Branch Id.");

		}

	}

	//7.Update Branch Manager
		public ResponseEntity<ResponseStructure<Branch>> updateManager(int id, String manager) {
			Branch branch = branchDao.updateManager(id, manager);
			if (branch !=null) {
				responseStructure.setMessage("Branch Manager Updated Successfully");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(branch);
				//return responseStructure;	
				return new ResponseEntity<ResponseStructure<Branch>>(HttpStatus.OK);
				
			} else {
				//responseStructure.setMessage("Branch Not Found");
				//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
				//responseStructure.setData(branch);
				//return responseStructure;
				//return new ResponseEntity<ResponseStructure<Branch>>(HttpStatus.NOT_FOUND);
				
				throw new IdNoTFoundException("Branch Data Not Found For Given Branch Id.");
			}
		}
		
	//7.Update Branch name
	public ResponseEntity<ResponseStructure<Branch>> updateBranchName(int id, String name) {
		Branch branch = branchDao.updateBranchNamer(id, name);
		if (branch !=null) {
			responseStructure.setMessage("Branch Name Updated Successfully");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branch);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Branch>>(HttpStatus.OK);
			
		} else {
			//responseStructure.setMessage("Branch Not Found");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(branch);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Branch>>(HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Branch Data Not Found For Given Branch Branch Id.");
		}
	}
	
	//9.Update all Branch/address/hospital
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id, int hid, int aid, Branch branch) {
          Hospital hospital = hospitalDao.getHospitalById(hid);
          Address address = addressDao.findAddressById(aid);
          if (hospital !=null && address !=null) {
			branch.setHospital(hospital);
			branch.setAddress(address);
			Branch dbBranch= branchDao.updateBranch(id, branch);
			if (dbBranch !=null) {
				responseStructure.setMessage("Branch Updated Successfully");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(dbBranch);
				//return responseStructure;
				return new ResponseEntity<ResponseStructure<Branch>>(HttpStatus.OK);
				
			} else {
				responseStructure.setMessage("Branch Not Found");
				responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
				responseStructure.setData(dbBranch);
				//return responseStructure;	
				return new ResponseEntity<ResponseStructure<Branch>>(HttpStatus.NOT_FOUND);
				
            }
		}
        else {
        	responseStructure.setMessage("Branch Not Found");
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(branch);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Branch>>(HttpStatus.NOT_FOUND);
          }

	}
	
	//10.Find Branch By Name
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByName(String name) {
		//return branchDao.getBranchByName(id, name);
		ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<>();
        List<Branch>branch = branchDao.getBranchByName(name);
		if (branch.isEmpty()) {
			
			//responseStructure.setMessage("Branch Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(branch);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new NameNotFoundException("Branch Data Not Found For Given Branch Name.");
			
		} else {
			responseStructure.setMessage("Branch Found Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure, HttpStatus.FOUND);
		}
	}
	
	//11. Find Branches By Hospital
	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchesByHospital(int hId) {
		Hospital dbHospital = hospitalDao.getHospitalById(hId);
		//return branchDao.findBranchesByHospital(dbHospital);
		
		ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<>();
		List<Branch> branchs = branchDao.findBranchesByHospital(dbHospital);
		
		if (branchs.isEmpty()) {
			//responseStructure.setMessage("Branches Data Not Found For Given Manager..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(branchs);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Hospital Data Not Found For Given Hospital Id.");
		}
		responseStructure.setMessage("Branch Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(branchs);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.FOUND);
	}
		
//	// Find Branches By Hospital Name
//	public List<Branch> findBranchesByHospitalName(String name) {
//	    Hospital hospital= hospitalDao.getHospitalByName(name);
//		return branchDao.findBranchesByHospitalName(hospital);
//	}
	
}
