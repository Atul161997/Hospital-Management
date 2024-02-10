package com.qsp.Hospital_Management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.MedItemsDao;
import com.qsp.Hospital_Management.dao.MedOrderDao;
import com.qsp.Hospital_Management.dto.MedItems;
import com.qsp.Hospital_Management.dto.MedOrder;
import com.qsp.Hospital_Management.exception.IdNoTFoundException;
import com.qsp.Hospital_Management.exception.NameNotFoundException;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class MedItemsService {
	
	@Autowired
	private MedItemsDao medItemsDao;
	
	@Autowired
	private MedOrderDao medOrderDao;

	
	ResponseStructure<MedItems> responseStructure = new ResponseStructure<>();
	
	//1.Save
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(MedItems medItems, int moid) {
		MedOrder medOrder=medOrderDao.getMedOrderById(moid);
		if (medOrder!=null) {
			medItems.setMedOrder(medOrder);
			//return medItemsDao.saveMedItem(medItems);
			MedItems medItems2 = medItemsDao.saveMedItem(medItems);
			responseStructure.setMessage("MedItems Saved Successfully..!");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(medItems2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.FOUND);
		}
		return null;
	}

	//2.Find By Id
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(int id) {
		//return medItemsDao.getMedItemsById(id);
		MedItems medItems=medItemsDao.getMedItemsById(id);
		
		if (medItems!= null) {
			responseStructure.setMessage("MedItems Found Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(medItems);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.FOUND);
		} else {
			//responseStructure.setMessage("MedItems Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(medItems);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("MedItems Data Not Found With Given MedItems Id. ");
		}
	}

	//3.Delete
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItemsById(int id) {
		//return medItemsDao.deleteMedItemsById(id);
		MedItems medItems=medItemsDao.deleteMedItemsById(id);
		if (medItems!= null) {
			responseStructure.setMessage("MedItems Deleted Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(medItems);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.OK);
		} else {
			//responseStructure.setMessage("MedItems Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(medItems);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("MedItems Data Not Found With Given MedItems Id. ");
		}
	}

	//4.Update MedItems
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(int id, MedItems medItems) {
		//return medItemsDao.updateMedItems(id,medItems);
		 MedItems medItems2 = medItemsDao.updateMedItems(id,medItems);
		if (medItems2!= null) {
			responseStructure.setMessage("MedItems Updated Successfully For Given Id..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(medItems2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.OK);
		} else {
			//responseStructure.setMessage("MedItems Not Found For Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(medItems2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("MedItems Data Not Found With Given MedItems Id. ");
		}
	}

	//5.find All MedItems
	public ResponseEntity<ResponseStructure<List<MedItems>>> getAllMedItems() {
		//return medItemsDao.getAllMedItems();
		ResponseStructure< List<MedItems>> responseStructure = new ResponseStructure<>();
		 List<MedItems> medItems= medItemsDao.getAllMedItems();
		
		if (medItems.isEmpty()) {
			//responseStructure.setMessage("MedItems Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(medItems);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<MedItems>>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("MedItems Data Not Found. ");
			
		} else {
			responseStructure.setMessage("MedItems Found Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(medItems);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<List<MedItems>>>(responseStructure, HttpStatus.FOUND);
		}   
	}

	//6.Find By Name
	public ResponseEntity<ResponseStructure<List<MedItems>>> getMedItemsByName(String name) {
		//return medItemsDao.getMedItemsByName(name);
		
		ResponseStructure< List<MedItems>> responseStructure = new ResponseStructure<>();
		 List<MedItems> medItems = medItemsDao.getMedItemsByName(name);
		
		if (medItems.isEmpty()) {
			//responseStructure.setMessage("MedItems Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(medItems);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<MedItems>>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new NameNotFoundException("MedItems Data Not Found For Given MedItems Name.");
			
		} else {
			responseStructure.setMessage("MedItems Found Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(medItems);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<List<MedItems>>>(responseStructure, HttpStatus.FOUND);
		}   
	}

}
