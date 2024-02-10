package com.qsp.Hospital_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.AddressDao;
import com.qsp.Hospital_Management.dto.Address;
import com.qsp.Hospital_Management.exception.CityNotFoundException;
import com.qsp.Hospital_Management.exception.IdNoTFoundException;
import com.qsp.Hospital_Management.exception.PincodeNotFoundException;
import com.qsp.Hospital_Management.exception.StateNotFoundException;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;

	ResponseStructure<Address> responseStructure = new ResponseStructure<>();
	//1.Save
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		//return addressDao.saveAddress(address);
		responseStructure.setMessage("Address Saved Successfully..!");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}

	//2.Find By Id
	public ResponseEntity<ResponseStructure<Address>> findAddressById(int id) {
		//return addressDao.findAddressById(id);
		Address address=addressDao.findAddressById(id);
		if (address != null) {
			responseStructure.setMessage("Address Found Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(addressDao.findAddressById(id));
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		} else {
			//responseStructure.setMessage("Address Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(addressDao.findAddressById(id));
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException(" Address Data Not Found For Given address Id.");
		}
	}

	//3.Find All Address
	public ResponseEntity<ResponseStructure<List<Address>>> getAllAddree() {
		//return addressDao.getAllAddree();
		ResponseStructure<List<Address>> responseStructure = new ResponseStructure<>();
		List<Address> addresses = addressDao.getAllAddree();
		
		if (addresses.isEmpty()) {
			//responseStructure.setMessage("Address Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(addresses);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException(" Address Data Not Found .");
		}
		responseStructure.setMessage("Addresses Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(addresses);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructure,HttpStatus.FOUND);
		
		
	}

	//4. Delete By Id
	public ResponseEntity<ResponseStructure<Address>> deleteById(int id) {
		//return addressDao.deleteAddress(id);
		Address address=addressDao.deleteAddress(id);
		if (address != null) {
			responseStructure.setMessage("Address Deleted Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(address);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Address Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(address);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException(" Address Data Not Found For Given address Id.");
		}
	}

	//5. Update All
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address) {
		//return addressDao.updateAddress(id,address);
		Address address2=addressDao.updateAddress(id,address);
		
		if (address2 != null) {
			responseStructure.setMessage("Address Updated Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(address2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Address Not Found With Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(address2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException(" Address Data Not Found For Given address Id.");
		}
	}

	//6. Update City
	public ResponseEntity<ResponseStructure<Address>> updateCity(int id, String city) {
		//return addressDao.updateCity(id,city);
        Address address2=addressDao.updateCity(id,city);
		
		if (address2 != null) {
			responseStructure.setMessage("Address City Updated Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(address2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Address Not Found With Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(address2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException(" Address Data Not Found For Given address Id.");
		}
	}

	//7.Update State
	public ResponseEntity<ResponseStructure<Address>> updateState(int id, String state) {
		//return addressDao.updateState(id,state);
		 Address address2 = addressDao.updateState(id,state);
			
			if (address2 != null) {
				responseStructure.setMessage("Address State Updated Successfully..!");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(address2);
				//return responseStructure;
				return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
			} else {
				//responseStructure.setMessage("Address Not Found With Given Id..!");
				//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
				//responseStructure.setData(address2);
				//return responseStructure;
				//return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.NOT_FOUND);
				
				throw new IdNoTFoundException(" Address Data Not Found For Given address Id.");
			}
	}

	//8.Update Pincode
	public ResponseEntity<ResponseStructure<Address>> updatePincode(int id, int pincode) {
		//return addressDao.updatePincode(id,pincode);
		Address address2 = addressDao.updatePincode(id,pincode);
		if (address2 != null) {
			responseStructure.setMessage("Address Pincode Updated Successfully..!");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(address2);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		} else {
			//responseStructure.setMessage("Address Not Found With Given Id..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(address2);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new IdNoTFoundException(" Address Data Not Found For Given address Id.");
		}
	}

	//9. Find By Pincode
	public ResponseEntity<ResponseStructure<Address>> getAddressByPinCode(int pincode) {
		//return addressDao.getAddressByPinCode(pincode);
		Address address = addressDao.getAddressByPinCode(pincode);
		if (address != null) {
			responseStructure.setMessage("Address Found Successfully With Given Id..!");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		} else {
			//responseStructure.setMessage("Address Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(address);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new PincodeNotFoundException("Address Data Not Found For Given Pincode.");
		}
	}
	
	//10. Find By City
	public ResponseEntity<ResponseStructure<List<Address>>> getAddressByCity(String city) {
		//return addressDao.getAddressByCity(city);
		ResponseStructure<List<Address>> responseStructure = new ResponseStructure<>();
		List<Address> addresses = addressDao.getAddressByCity(city);
		
		if (addresses.isEmpty()) {
			//responseStructure.setMessage("Address Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(addresses);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new CityNotFoundException("Address Data Not Found For Given City");
		}
		responseStructure.setMessage("Addresses Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(addresses);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructure,HttpStatus.FOUND);
	}

	//11.Find By State
	public ResponseEntity<ResponseStructure<List<Address>>> getAddressByState(String state) {
		//return addressDao.getAddressByState(state);
		ResponseStructure<List<Address>> responseStructure = new ResponseStructure<>();
		List<Address> addresses = addressDao.getAddressByState(state);
		
		if (addresses.isEmpty()) {
			//responseStructure.setMessage("Address Not Found..!");
			//responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			//responseStructure.setData(addresses);
			//return responseStructure;
			//return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructure,HttpStatus.NOT_FOUND);
			
			throw new StateNotFoundException("Address Data Not Found For Given State.");
		}
		responseStructure.setMessage("Addresses Found Successfully..!");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(addresses);
		//return responseStructure;
		return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructure,HttpStatus.FOUND);

	}
}
