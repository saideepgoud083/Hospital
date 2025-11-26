package com.alpha.Hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.Hospital.responcestucture;
import com.alpha.Hospital.entity.doctor;
import com.alpha.Hospital.execption.doctornotfound;
import com.alpha.Hospital.repository.doctorrepo;


@Service
public class doctorService {
@Autowired
	private doctorrepo dr;




	public void acceptDoctor(doctor d) {
		// TODO Auto-generated method stub
		dr.save(d);
	}
	
	
	/*******finding doctor***********/
	public responcestucture<doctor> findst(int id) {
		// TODO Auto-generated method stub
		doctor d = dr.findById(id).orElseThrow(()-> new doctornotfound() );
		responcestucture<doctor> rs = new responcestucture<doctor>();
		
			
			rs.setStatuscode(HttpStatus.FOUND.value());	
			rs.setMasg("doctor with id "+id+"found");
			rs.setData(d);
		
		
		return rs;
	}

	
	/***************DELETING DOCTOR************/

	public void deletstudent(int id) {
		// TODO Auto-generated method stub
		
		dr.deleteById(id);
		
		
		
		
	}

	/***************UPDATING DOCTOR************/
	public void updatedoctor(int id, String newname) {
		
		
		doctor d = dr.findById(id).get();
		d.setName(newname);
		dr.save(d);
		
	}
	
	
	
	

}
