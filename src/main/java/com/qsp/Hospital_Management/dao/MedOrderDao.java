package com.qsp.Hospital_Management.dao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Hospital_Management.dto.MedOrder;
import com.qsp.Hospital_Management.repo.MedOrderRepo;

@Repository
public class MedOrderDao {

	@Autowired
	private MedOrderRepo medOrderRepo;

	
	//1.Save
	public MedOrder saveOrder(MedOrder medOrder) {
		return medOrderRepo.save(medOrder);
	}


	//2.Find By id
	public MedOrder getMedOrderById(int id) {
		Optional<MedOrder>optional=medOrderRepo.findById(id);
		if (optional.isPresent()) {
			return  optional.get();
		}
		return null;
	}


	//3.Delete
	public MedOrder deleteMedOrderById(int id) {
		Optional<MedOrder>optional=medOrderRepo.findById(id);
		if (optional.isPresent()) {
			medOrderRepo.deleteById(id);
			return optional.get();
		}
		return null;
	}


	//4.Update MedOrder
	public MedOrder updateMedOrder(int id, MedOrder medOrder) {
		Optional<MedOrder>optional = medOrderRepo.findById(id);
		if (optional.isPresent()) {
			medOrder.setMoId(id);
			medOrder.setEncounter(optional.get().getEncounter());
			return medOrderRepo.save(medOrder);
		}
		return null;
	}

	//5.Find All MedOrder
	public List<MedOrder> getAllMedOrder() {
		return medOrderRepo.findAll();
	}


	//6.Find By Doctor
	public List<MedOrder> getMedOrderByDoctor(String doctor) {
		return medOrderRepo.findMedOrderByDoctor(doctor);
	}


	//7.Find By Date
	public List<MedOrder> getMedOrderByDate(Date date) {
		return medOrderRepo.findMedOrderByDate(date);
	}
}
