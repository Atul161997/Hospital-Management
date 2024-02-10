package com.qsp.Hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.Hospital_Management.dto.Perosn;
import com.qsp.Hospital_Management.repo.PersonRepo;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepo personRepo;

	//1.Save
	public Perosn savePerson(Perosn perosn) {
		return personRepo.save(perosn);
	}

	//2.Find By Id
	public Perosn getPersonById(int id) {
		Optional<Perosn>optional=personRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	//3.Find All
	public List<Perosn> getAllPerson() {
		return personRepo.findAll();
	}

	//4.Delete By Id
	public Perosn deletePersonById(int id) {
		Optional<Perosn>optional=personRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		personRepo.deleteById(id);
		return optional.get();
	}

	//5.Update All
	public Perosn updatePerson(int id, Perosn perosn) {
		Optional<Perosn>optional=personRepo.findById(id);
		if (optional.isPresent()) {
			perosn.setPId(id);
			return personRepo.save(perosn);
		}
		return null;
	}

	//6.Find By Name
	public List<Perosn> getByName(String name) {
		return personRepo.findPersonByName(name);
	}

	//7.Find By Email
	public Perosn getByEmail(String email) {
		return personRepo.findPersonByEmail(email);
	}

	//8.Find By Phone
	public Perosn getByPhone(long phone) {
		return personRepo.findPersonByPhone(phone);
	}

	//9.Find By Address
	public List<Perosn> getByAddress(String address) {
		return personRepo.findPersonByAddress(address);
	}

	//10.Update Name
	public Perosn updatePersonName(int id, String name) {
	    Optional<Perosn> optional = personRepo.findById(id);
	    if (optional.isPresent()) {
			Perosn dbPerosn=optional.get();
			dbPerosn.setName(name);
			return personRepo.save(dbPerosn);
		}
		return null;
	}

	//11.Update Phone
	public Perosn updatePersonPhone(int id, long phone) {
		Optional<Perosn>optional=personRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Perosn dbPerosn=optional.get();
		dbPerosn.setPhone(phone);
		return personRepo.save(dbPerosn);
		
	}

	//12.Update Email
	public Perosn updatePersonEmail(int id, String email) {
		Optional<Perosn>optional=personRepo.findById(id);
		if (optional.isPresent()) {
			Perosn dbPerosn=optional.get();
			dbPerosn.setEmail(email);
			return personRepo.save(dbPerosn);
		}
		return null;
	}

	//13.Update Address
	public Perosn updatePersonAddress(int id, String address) {
		Optional<Perosn> optional=personRepo.findById(id);
		if (optional.isPresent()) {
			Perosn dbPerosn=optional.get();
			dbPerosn.setAddress(address);
			return personRepo.save(dbPerosn);
		}
		return null;
	}
}
