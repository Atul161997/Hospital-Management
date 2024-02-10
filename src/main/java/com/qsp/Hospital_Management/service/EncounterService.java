package com.qsp.Hospital_Management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.BranchDao;
import com.qsp.Hospital_Management.dao.EncounterDao;
import com.qsp.Hospital_Management.dao.PersonDao;
import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.dto.Encounter;
import com.qsp.Hospital_Management.dto.Perosn;
import com.qsp.Hospital_Management.exception.CauseNotFoundException;
import com.qsp.Hospital_Management.exception.CostNotFoundException;
import com.qsp.Hospital_Management.exception.IdNoTFoundException;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private BranchDao branchDao;

	
	ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
	
	//1.Save
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
		Perosn perosn = personDao.getPersonById(pid);
		Branch branch = branchDao.getBranchById(bid);
		
		if (perosn!=null && branch!=null) {
			encounter.setPerosn(perosn);
			
			List<Branch> listBranchs = new ArrayList<>();
			listBranchs.add(branch);
			
			encounter.setBranchs(listBranchs);
			//return encounterDao.saveEncounter(encounter);
			
			Encounter encounter2 = encounterDao.saveEncounter(encounter);
			responseStructure.setMessage("Encounter Saved Successfully..!");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(encounter2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.CREATED);
		}
		return null;
	}


	//2.Find Encounter By Id
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id) {
		//return encounterDao.getEncounterById(id);
		Encounter encounter=encounterDao.getEncounterById(id);
		if (encounter!= null) {
			responseStructure.setMessage("Encounter Found Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.FOUND);
		} else {
			//responseStructure.setMessage("Encounter Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(encounter);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Encounter Data Not Found With Given Encounter Id. ");
		}
	}


	//3.Find All Encounter
	public ResponseEntity<ResponseStructure<List<Encounter>>> getAllEncounter() {
		//return encounterDao.getAllEncounter();
		
		ResponseStructure<List<Encounter>> responseStructure = new ResponseStructure<>();
		List<Encounter> encounters = encounterDao.getAllEncounter();
		
		if (encounters.isEmpty()) {
			//responseStructure.setMessage("Encounter Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(encounters);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Encounter>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Encounter Data Not Found. ");
		}
		responseStructure.setMessage("Encounter Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(encounters);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Encounter>>>(responseStructure,HttpStatus.FOUND);
	}


	//4.Find Encounter By cause
	public ResponseEntity<ResponseStructure<List<Encounter>>> getEncounterByCasue(String cause) {
		//return encounterDao.getEncounterByCasue(cause);
		
		ResponseStructure<List<Encounter>> responseStructure = new ResponseStructure<>();
		List<Encounter> encounters = encounterDao.getEncounterByCasue(cause);
		
		if (encounters.isEmpty()) {
			//responseStructure.setMessage("Encounter Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(encounters);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Encounter>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new CauseNotFoundException("Encounter Data Not Found For Given Encounter Cause.");
		}
		responseStructure.setMessage("Encounter Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(encounters);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Encounter>>>(responseStructure,HttpStatus.FOUND);
	}

	//5.Find Encounter By Cost
	public ResponseEntity<ResponseStructure<List<Encounter>>> getEncounterByCost(double cost) {
		//return encounterDao.getEncounterByCost(cost);
		
		ResponseStructure<List<Encounter>> responseStructure = new ResponseStructure<>();
		List<Encounter> encounters = encounterDao.getEncounterByCost(cost);
		
		if (encounters.isEmpty()) {
			//responseStructure.setMessage("Encounter Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(encounters);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Encounter>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new CostNotFoundException("Encounter Data Not Found For Given Cost.");
		}
		responseStructure.setMessage("Encounter Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(encounters);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Encounter>>>(responseStructure,HttpStatus.FOUND);
	}


	//6. Update Encounter  ***
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int id, Encounter encounter) {
		//return encounterDao.updateEncounter(encounter, id);
		
		Encounter encounter2 = encounterDao.updateEncounter(encounter, id);
		if (encounter2!= null) {
			responseStructure.setMessage("Encounter Updated Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(encounter2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Encounter Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(encounter2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Encounter Data Not Found With Given Encounter Id. ");
		}
	}


	//7.Delete Encounter
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {
		//return encounterDao.deleteEncounter(id);
		Encounter encounter=encounterDao.deleteEncounter(id);
		if (encounter!= null) {
			responseStructure.setMessage("Encounter Deleted Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Encounter Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(encounter);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Encounter Data Not Found With Given Encounter Id. ");
		}
	}


	//8.Update Cause  ***
	public ResponseEntity<ResponseStructure<Encounter>> updateCause(int id, String cause) {
		//return encounterDao.updateCause(id,cause);
		
		Encounter encounter2 = encounterDao.updateCause(id,cause);
		if (encounter2!= null) {
			responseStructure.setMessage("Encounter Cause Updated Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(encounter2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Encounter Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(encounter2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Encounter Data Not Found With Given Encounter Id. ");
		}
	}


	//9. Update Cost  **
	public ResponseEntity<ResponseStructure<Encounter>> updateCost(int id, double cost) {
		//return encounterDao.updateCost(id,cost);
		
		Encounter encounter2 = encounterDao.updateCost(id,cost);
		if (encounter2!= null) {
			responseStructure.setMessage("Encounter Cost Updated Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(encounter2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Encounter Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(encounter2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Encounter Data Not Found With Given Encounter Id. ");
		}
	}


	
}
