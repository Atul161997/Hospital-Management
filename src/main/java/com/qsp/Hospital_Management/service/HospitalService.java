package com.qsp.Hospital_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.HospitalDao;
import com.qsp.Hospital_Management.dto.Hospital;
import com.qsp.Hospital_Management.exception.CEONotFoundException;
import com.qsp.Hospital_Management.exception.EmailNotFoundException;
import com.qsp.Hospital_Management.exception.IdNoTFoundException;
import com.qsp.Hospital_Management.exception.NameNotFoundException;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao hospitalDao;

	ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();  //It is user define Class
	
	// ResponseEntity build in class to match statuscode for ResponseStructure class[user define class]

	// 1.save
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {

		responseStructure.setMessage("Hospital Saved Successfully..!");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());  // Enum httpStatus
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.CREATED); // status code same
		//return responseStructure;

		// return hospitalDao.saveHospital(hospital);
	}

	// 2.Find By id
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		// return hospitalDao.getHospitalById(id);

		Hospital hospital = hospitalDao.getHospitalById(id);
		// ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		if (hospital != null) {
			responseStructure.setMessage("Hospital Found Successfully..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(hospitalDao.getHospitalById(id));
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.FOUND);
		} else {
			//responseStructure.setMessage("Hospital Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(hospitalDao.getHospitalById(id));
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.NOT_FOUND);
			
			//throw new HospitalIdNotFound();
			
			throw new IdNoTFoundException("Hospital Data Not Found For given Hospital Id");
		}

	}

	// 3.Delete By Id
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(int id) {
		// return hospitalDao.deleteHospitalById(id);
		Hospital hospital = hospitalDao.deleteHospitalById(id);
		if (hospital != null) {
			responseStructure.setMessage("Hospital Deleted Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Hospital Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(hospital);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Hospital Data Not Found For given Hospital Id");
		}

	}

	// 4.Find All
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital() {
		// return hospitalDao.getAllHospital();
		ResponseStructure<List<Hospital>> responseStructure = new ResponseStructure<>();
		List<Hospital> hospital = hospitalDao.getAllHospital();
		
		if (hospital.isEmpty()) {
			//responseStructure.setMessage("Hospital Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(hospital);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructure,HttpStatus.NOT_FOUND);
			 
			throw new IdNoTFoundException("Hospital Data Not Found ???");
		}
		responseStructure.setMessage("Hospital Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(hospital);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructure,HttpStatus.FOUND);
		
		
		//OR  It Gives ERROR
		
//		if (hospital != null) {
//			responseStructure.setMessage("Hospital Found Successfully..!");
//			responseStructure.setStatusCode(HttpStatus.FOUND.value());
//			responseStructure.setData(hospital);
//			return responseStructure;
//		} else {
//			responseStructure.setMessage("Hospital Not Found..!");
//			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
//			responseStructure.setData(hospital);
//			return responseStructure;
//		}
	}

	// 5.Find By Email
	public ResponseEntity<ResponseStructure<Hospital>> getByEmail(String email) {
		// return hospitalDao.getByEmail(email);
		Hospital hospital = hospitalDao.getByEmail(email);
		if (hospital != null) {
			responseStructure.setMessage("Hospital Found Successfully..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.FOUND);
		} else {
			//responseStructure.setMessage("Hospital Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(hospital);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new EmailNotFoundException("Hospital Data NOT Found for Given Hospital Email Id.");
		}
	}

	// 6. Find By Name
	public ResponseEntity<ResponseStructure<List<Hospital>>> getByName(String name) {
		//return hospitalDao.getByName(name);
		ResponseStructure<List<Hospital>> responseStructure = new ResponseStructure<>();
		List<Hospital> hospital=hospitalDao.getByName(name);
		if (hospital.isEmpty()) {
			//responseStructure.setMessage("Hospital Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(hospital);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new NameNotFoundException("Hospital Data Not Found For Given Hospital Name");
		}
		responseStructure.setMessage("Hospital Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(hospital);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructure,HttpStatus.FOUND);
		
	}

	//
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByName(String name) {
		//return hospitalDao.getHospitalByName(name);
		Hospital hospital = hospitalDao.getHospitalByName(name);
		if (hospital != null) {
			responseStructure.setMessage("Hospital Found Successfully..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.FOUND);
		} else {
			//responseStructure.setMessage("Hospital Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(hospital);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.NOT_FOUND);
			
			//throw new NameNotFoundException("Name Not Found");
		}
	}

	// 7.Find By CEO
	public ResponseEntity<ResponseStructure<List<Hospital>>> getByCEO(String ceo) {
		//return hospitalDao.getByCEO(ceo);
		ResponseStructure<List<Hospital>> responseStructure = new ResponseStructure<>();
		List<Hospital> hospital=hospitalDao.getByCEO(ceo);
		if (hospital.isEmpty()) {
			//responseStructure.setMessage("Hospital Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(hospital);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new CEONotFoundException("Hospital Data Not Found For Given Hospital CEO...?");
		}
		responseStructure.setMessage("Hospital Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(hospital);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructure,HttpStatus.FOUND);
	}

	// 8.Update All Hospital
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(int id, Hospital hospital) {
		// return hospitalDao.updateHospitalById(id,hospital);
		Hospital hospital2 = hospitalDao.updateHospitalById(id, hospital);
		if (hospital2 != null) {
			responseStructure.setMessage("Hospital Updated Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(hospital2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Hospital Not Found With Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(hospital2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Hospital Not Found For given Hospital Id");
		}

	}

	// 9. Update Hospital Name
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalName(int id, String name) {
		//return hospitalDao.updateHospitalName(id, name);
		Hospital hospital2 = hospitalDao.updateHospitalName(id, name);
		if (hospital2 != null) {
			responseStructure.setMessage("Hospital Name Updated Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(hospital2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Hospital Not Found With Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(hospital2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Hospital Not Found For given Hospital Id");
		}
	}

	// 10.Update Hospital Email
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalEmail(int id, String email) {
		//return hospitalDao.updateHospitalEmail(id, email);
		Hospital hospital2 = hospitalDao.updateHospitalEmail(id, email);
		if (hospital2 != null) {
			responseStructure.setMessage("Hospital Name Updated Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(hospital2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Hospital Not Found With Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(hospital2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Hospital Not Found For given Hospital Id");
		}
	}

	// 11.Update Hospital CEO
	public ResponseEntity<ResponseStructure<Hospital>> upadteHospitalCeo(int id, String ceo) {
		//return hospitalDao.upadteHospitalCeo(id, ceo);
		Hospital hospital2 = hospitalDao.upadteHospitalCeo(id, ceo);
		if (hospital2 != null) {
			responseStructure.setMessage("Hospital Name Updated Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(hospital2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Hospital Not Found With Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(hospital2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Hospital Not Found For given hospital Id");
		}
	}

}
