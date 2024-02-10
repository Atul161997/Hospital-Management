package com.qsp.Hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Hospital_Management.dto.Hospital;
import com.qsp.Hospital_Management.repo.HospitalRepo;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepo hospitalRepo;

	//1.save
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}

	//2.find By  id
	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional=hospitalRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	//3.Delete By Id
    public Hospital deleteHospitalById(int id) {
    	 Optional<Hospital> optional=hospitalRepo.findById(id);
 		
 		if (optional.isEmpty()) {
 			return null;
 		}
 		
 		Hospital hospital = optional.get();
 		hospitalRepo.delete(hospital);
		return hospital;
	}

    //4.Find All
	public List<Hospital> getAllHospital() {
		//return hospitalRepo.findAll();
		return hospitalRepo.getAllHospital();
	}

	//5.Find By Email
	public Hospital getByEmail(String email) {
		return hospitalRepo.findHospitalByEmail(email);
	}

	//6.Find By Name
	public List<Hospital> getByName(String name) {
		return hospitalRepo.findHospitalByName(name);
	}
	
	//
	public Hospital getHospitalByName(String name) {
		return hospitalRepo.findHospitalsByName(name);
	}

	//7.find By CEO
	public List<Hospital> getByCEO(String ceo) {
		return hospitalRepo.findHospitalByCeo(ceo);
	}
	
	//8.Update Hospital
	public Hospital updateHospitalById(int id, Hospital hospital) {
		Optional<Hospital> optional = hospitalRepo.findById(id);
		if (optional.isPresent()) {
			hospital.setHId(id);
			return hospitalRepo.save(hospital);
		}
		return null;
	}

	//9. Update Hospital Name
	public Hospital updateHospitalName(int id, String name) {
		Optional<Hospital> optional = hospitalRepo.findById(id);
		if (optional.isPresent()) {
			Hospital dbHospital=optional.get();
			dbHospital.setName(name);
			return hospitalRepo.save(dbHospital);
		}
		return null;
	}

	//10. Update Hospital Email
	public Hospital updateHospitalEmail(int id, String email) {
		Optional<Hospital> optional = hospitalRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Hospital dbHospital=optional.get();
		dbHospital.setEmail(email);
		return hospitalRepo.save(dbHospital);
	}

	//11.Update Hospital CEO
	public Hospital upadteHospitalCeo(int id, String ceo) {
		Optional<Hospital> optional = hospitalRepo.findById(id);
		if (optional.isPresent()) {
			Hospital dbHospital=optional.get();
			dbHospital.setCeo(ceo);
			return hospitalRepo.save(dbHospital);
		}
		return null;
	}

	

	
	
}
