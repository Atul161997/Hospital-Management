package com.qsp.Hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;

import com.qsp.Hospital_Management.dto.Encounter;
import com.qsp.Hospital_Management.repo.EncounterRepo;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepo encounterRepo;

	//1.Save
	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepo.save(encounter);
	}

	//2.Find Encounter By Id
	public Encounter getEncounterById(int id) {
		Optional<Encounter> optional = encounterRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	//3.Find All
	public List<Encounter> getAllEncounter() {
		return encounterRepo.findAll();
	}

	//4.Find Encounter By Cause
	public List<Encounter> getEncounterByCasue(String cause) {
		return encounterRepo.findEncounterByCause(cause);
	}

    //5.Find Encounter By cost
	public List<Encounter> getEncounterByCost(double cost) {
		return encounterRepo.findEncounterByCost(cost);
	}

	//6. Update Encounter
	public Encounter updateEncounter(Encounter encounter, int id) {
		Optional<Encounter> optional = encounterRepo.findById(id);
		if (optional.isPresent()) {
			encounter.setEId(id);
			encounter.setBranchs(optional.get().getBranchs());
			encounter.setPerosn(optional.get().getPerosn());
			return encounterRepo.save(encounter);
		}
		return null;
	}

	//7.Delete Encounter	
	public Encounter deleteEncounter(int id) {
		Optional<Encounter>optional=encounterRepo.findById(id);
		if (optional.isPresent()) {
			encounterRepo.deleteById(id);
			return optional.get();
		}
		return null;
	}

	//8.Update Cause
	public Encounter updateCause(int id, String cause) {
		Optional<Encounter> optional = encounterRepo.findById(id);
		if (optional.isPresent()) {
			Encounter encounter = optional.get();
			encounter.setEId(id);
			encounter.setCause(cause);
			return encounter;
		}
		return null;
	}

	//9.Update Cost
	public Encounter updateCost(int id, double cost) {
		Optional<Encounter> optional = encounterRepo.findById(id);
		if (optional.isPresent()) {
			Encounter encounter = optional.get();
			encounter.setEId(id);
			encounter.setCost(cost);
			return encounter;
		}
		return null;
	}
	
	
}
