package com.qsp.Hospital_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.PersonDao;
import com.qsp.Hospital_Management.dto.Perosn;
import com.qsp.Hospital_Management.exception.AddressNotFoundException;
import com.qsp.Hospital_Management.exception.EmailNotFoundException;
import com.qsp.Hospital_Management.exception.IdNoTFoundException;
import com.qsp.Hospital_Management.exception.NameNotFoundException;
import com.qsp.Hospital_Management.exception.PhoneNotFoundException;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	ResponseStructure<Perosn> responseStructure = new ResponseStructure<>();
	
	//1.Save
	public ResponseEntity<ResponseStructure<Perosn>> savePerson(Perosn perosn) {
		//return personDao.savePerson(perosn);
		responseStructure.setMessage("Person Saved Successfully..!");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(personDao.savePerson(perosn));
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure, HttpStatus.CREATED);
	}

	//2. Find By Id
	public ResponseEntity<ResponseStructure<Perosn>> getPersonById(int id) {
		//return personDao.getPersonById(id);
		Perosn perosn=personDao.getPersonById(id);
		if (perosn != null) {
			responseStructure.setMessage("Person Found Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(personDao.getPersonById(id));
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure, HttpStatus.FOUND);
		} else {
			//responseStructure.setMessage("Person Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(personDao.getPersonById(id));
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Person Data Not Found With Given Persion Id. ");
		}
	}

	//3.Find All
	public ResponseEntity<ResponseStructure<List<Perosn>>> getAllPerson() {
		//return personDao.getAllPerson();
		ResponseStructure<List<Perosn>> responseStructure = new ResponseStructure<>();
		List<Perosn> perosns =  personDao.getAllPerson();
		
		if (perosns.isEmpty()) {
			//responseStructure.setMessage("Person Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(perosns);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Perosn>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Person Data Not Found. ");
		}
		responseStructure.setMessage("Presons Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(perosns);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Perosn>>>(responseStructure,HttpStatus.FOUND);
	}

	//4.Delete By Id
	public ResponseEntity<ResponseStructure<Perosn>> deletePersonById(int id) {
		//return personDao.deletePersonById(id);
		Perosn perosn=personDao.deletePersonById(id);
		if (perosn != null) {
			responseStructure.setMessage("Person Deleted Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(perosn);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure, HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Person Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(perosn);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Person Data Not Found With Given Persion Id. ");
		}
	}

	//5.Update All
	public ResponseEntity<ResponseStructure<Perosn>> updatePerson(int id, Perosn perosn) {
		//return personDao.updatePerson(id,perosn);
		Perosn perosn2=personDao.updatePerson(id,perosn);
		
		if (perosn2 != null) {
			responseStructure.setMessage("Person Updated Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(perosn2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("Person Not Found With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(perosn2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Person Data Not Found With Given Persion Id. ");
		}
	}

	//6.Find By Name
	public ResponseEntity<ResponseStructure<List<Perosn>>> getByname(String name) {
		//return personDao.getByName(name);
		ResponseStructure<List<Perosn>> responseStructure = new ResponseStructure<>();
		List<Perosn> perosns =   personDao.getByName(name);
		
		if (perosns.isEmpty()) {
			//responseStructure.setMessage("Person Data With Given Name Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(perosns);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Perosn>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new NameNotFoundException("Person Data Not Found For Given Person Name.");
		}
		responseStructure.setMessage("Presons Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(perosns);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Perosn>>>(responseStructure,HttpStatus.FOUND);
	}

	//7.Find By Email
	public ResponseEntity<ResponseStructure<Perosn>> getByEmail(String email) {
		//return personDao.getByEmail(email);
		Perosn perosn = personDao.getByEmail(email);
		if (perosn != null) {
			responseStructure.setMessage("Person Found Successfully With Given Email..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(perosn);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure, HttpStatus.FOUND);
		} else {
			//responseStructure.setMessage("Person With Given Email Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(perosn);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new EmailNotFoundException("Person Data Not Found For Given Person Email id. ");
		}
	}

	//8.Find By Phone
	public ResponseEntity<ResponseStructure<Perosn>> getByPhone(long phone) {
		//return personDao.getByPhone(phone);
		Perosn perosn = personDao.getByPhone(phone);
		if (perosn != null) {
			responseStructure.setMessage("Person Found Successfully With Given Phone..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(perosn);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure, HttpStatus.FOUND);
		} else {
			//responseStructure.setMessage("Person With Given Phone Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(perosn);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure, HttpStatus.NOT_FOUND);
			
			throw new PhoneNotFoundException("Person Data Not Found For Given Person Phone Number. ");
		}
	}

	//9.Find By Address
	public ResponseEntity<ResponseStructure<List<Perosn>>> getByAddress(String address) {
		//return personDao.getByAddress(address);
		ResponseStructure<List<Perosn>> responseStructure = new ResponseStructure<>();
		List<Perosn> perosns = personDao.getByAddress(address);
		
		if (perosns.isEmpty()) {
			//responseStructure.setMessage("Person Data With Given Address Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(perosns);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Perosn>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new AddressNotFoundException("Person Data Not Found For Given Person Address. ");
		}
		responseStructure.setMessage("Presons Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(perosns);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Perosn>>>(responseStructure,HttpStatus.FOUND);
	}

	//10.Update Name
	public ResponseEntity<ResponseStructure<Perosn>> updatePersonName(int id, String name) {
		//return personDao.updatePersonName(id,name);
		Perosn perosn = personDao.updatePersonName(id,name);
		if (perosn!= null) {
			responseStructure.setMessage("Person Name Updated Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(perosn);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Person Not Found With Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(perosn);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Person Data Not Found With Given Persion Id. ");
		}
	}

	//11.Update Phone
	public ResponseEntity<ResponseStructure<Perosn>> updatePersonPhone(int id, long phone) {
		//return personDao.updatePersonPhone(id,phone);
		Perosn perosn = personDao.updatePersonPhone(id,phone);
		if (perosn!= null) {
			responseStructure.setMessage("Person Phone Updated Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(perosn);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Person Not Found With Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(perosn);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Person Data Not Found With Given Persion Id. ");
		}
	}

	//12.Update Email
	public ResponseEntity<ResponseStructure<Perosn>> updatePersonEmail(int id, String email) {
		//return personDao.updatePersonEmail(id, email);
		Perosn perosn = personDao.updatePersonEmail(id, email);
		if (perosn!= null) {
			responseStructure.setMessage("Person Email Updated Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(perosn);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Person Not Found With Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(perosn);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Person Data Not Found With Given Persion Id. ");
		}
	}

	//13.Update Address
	public ResponseEntity<ResponseStructure<Perosn>> updatePersonAddress(int id, String address) {
		//return personDao.updatePersonAddress(id,address);
		Perosn perosn = personDao.updatePersonAddress(id,address);
		if (perosn!= null) {
			responseStructure.setMessage("Person Address Updated Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(perosn);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Person Not Found With Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(perosn);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Perosn>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException("Person Data Not Found With Given Persion Id. ");
		}
	}
}
