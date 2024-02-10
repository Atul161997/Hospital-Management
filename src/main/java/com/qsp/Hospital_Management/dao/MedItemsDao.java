package com.qsp.Hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Hospital_Management.dto.MedItems;
import com.qsp.Hospital_Management.repo.MedItemsRepo;

@Repository
public class MedItemsDao {

	@Autowired
	private MedItemsRepo medItemsRepo;

	
	//1.Save
	public MedItems saveMedItem(MedItems medItems) {
		return medItemsRepo.save(medItems);
	}


	//2.Find By id
	public MedItems getMedItemsById(int id) {
		Optional<MedItems> optional= medItemsRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}


	//3.Delete
	public MedItems deleteMedItemsById(int id) {
		Optional<MedItems> optional= medItemsRepo.findById(id);
		if (optional.isPresent()) {
			medItemsRepo.deleteById(id);
			return optional.get();
		}
		return null;
	}

    //4.Update MedItems
	public MedItems updateMedItems(int id, MedItems medItems) {
		Optional<MedItems> optional = medItemsRepo.findById(id);
		if (optional.isPresent()) {
			medItems.setMId(id);
			medItems.setMedOrder(optional.get().getMedOrder());
			return medItemsRepo.save(medItems);
		}
		return null;
	}


	//5.Find All MedItems
	public List<MedItems> getAllMedItems() {
		return medItemsRepo.findAll();
	}


	//6.Find By Name
	public List<MedItems> getMedItemsByName(String name) {
		return medItemsRepo.findMedItemsByName(name);
	}
}
