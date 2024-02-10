package com.qsp.Hospital_Management.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.EncounterDao;
import com.qsp.Hospital_Management.dao.MedOrderDao;
import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.dto.Encounter;
import com.qsp.Hospital_Management.dto.MedOrder;
import com.qsp.Hospital_Management.dto.Perosn;
import com.qsp.Hospital_Management.exception.DateNotFoundException;
import com.qsp.Hospital_Management.exception.DoctoreNotFoundException;
import com.qsp.Hospital_Management.exception.IdNoTFoundException;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class MedOrderService {
	
	@Autowired
	private MedOrderDao medOrderDao;
	
	@Autowired
	private EncounterDao encounterDao;

	ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
	
	//1.Save
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder, int eid) {
		Encounter encounter=encounterDao.getEncounterById(eid);
		if (encounter!=null) {
			medOrder.setEncounter(encounter);
			//return medOrderDao.saveOrder(medOrder);
			MedOrder medOrder2 = medOrderDao.saveOrder(medOrder);
			responseStructure.setMessage("MedOrder Saved Successfully..!");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(medOrder2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.CREATED);
		}
		return null;
	}

	//2.Find By Id
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id) {
		//return medOrderDao.getMedOrderById(id);
		MedOrder medOrder = medOrderDao.getMedOrderById(id);
		if (medOrder!= null) {
			responseStructure.setMessage("MedOrder Found Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(medOrder);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.FOUND);
		} else {
			//responseStructure.setMessage("MedOrder Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(medOrder);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("MedOrde Data Not Found With Given MedOrder Id. ");
		}
	}

	//3.Delete
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrderById(int id) {
		//return medOrderDao.deleteMedOrderById(id);
		MedOrder medOrder=medOrderDao.deleteMedOrderById(id);
		if (medOrder!= null) {
			responseStructure.setMessage("MedOrder Deleted Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(medOrder);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.OK);
		} else {
			//responseStructure.setMessage("MedOrder Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(medOrder);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("MedOrde Data Not Found With Given MedOrder Id. ");
		}
	}

	//4.Update MedOrder
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id, MedOrder medOrder) {
		//return medOrderDao.updateMedOrder(id,medOrder);
		MedOrder medOrder2 =  medOrderDao.updateMedOrder(id,medOrder);
		if (medOrder2!= null) {
			responseStructure.setMessage("MedOrder Updated Successfully For Given Id..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(medOrder2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.OK);
		} else {
			//responseStructure.setMessage("MedOrder Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(medOrder2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("MedOrde Data Not Found With Given MedOrder Id. ");
		}
	}

	//5.Find All MedORder
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrder() {
		//return medOrderDao.getAllMedOrder();
		ResponseStructure<List<MedOrder>> responseStructure = new ResponseStructure<>();
		List<MedOrder> medOrder = medOrderDao.getAllMedOrder();
		
		if (medOrder.isEmpty()) {
			//responseStructure.setMessage("Branches Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(medOrder);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<MedOrder>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("MedOrde Data Not Found. ");
		}
		responseStructure.setMessage("Branch Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(medOrder);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<MedOrder>>>(responseStructure,HttpStatus.FOUND);
	}
	

	//6.Find By Doctor
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getMedOrderByDoctor(String doctor) {
		//return medOrderDao.getMedOrderByDoctor(doctor);
		ResponseStructure<List<MedOrder>> responseStructure = new ResponseStructure<>();
		List<MedOrder> medOrder = medOrderDao.getMedOrderByDoctor(doctor);
		
		if (medOrder.isEmpty()) {
			//responseStructure.setMessage("MedOrder Not Found For Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(medOrder);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<MedOrder>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new DoctoreNotFoundException("MedOrder Data Not Found For Given Doctor.");
		}
		responseStructure.setMessage("MedOrder Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(medOrder);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<MedOrder>>>(responseStructure,HttpStatus.FOUND);
		
		
	}

	//7.Find by Date
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getMedOrderByDate(Date date) {
		//return medOrderDao.getMedOrderByDate(date);
		ResponseStructure<List<MedOrder>> responseStructure = new ResponseStructure<>();
		List<MedOrder> medOrder = medOrderDao.getMedOrderByDate(date);
		
		if (medOrder.isEmpty()) {
			//responseStructure.setMessage("MedOrder Not Found For Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(medOrder);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<MedOrder>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new DateNotFoundException("MedOrder Data Not Found For Given MedOrder Date.");
		}
		responseStructure.setMessage("MedOrder Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(medOrder);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<MedOrder>>>(responseStructure,HttpStatus.FOUND);
	}

}
