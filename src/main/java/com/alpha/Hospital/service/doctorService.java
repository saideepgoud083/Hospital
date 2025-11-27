package com.alpha.Hospital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.Hospital.responcestucture;
import com.alpha.Hospital.entity.Patient;
import com.alpha.Hospital.entity.doctor;
import com.alpha.Hospital.execption.allreadydoctorwasexiestonthsd;
import com.alpha.Hospital.execption.allreadypatientwasexistwithid;
import com.alpha.Hospital.execption.doctornotfound;
import com.alpha.Hospital.repository.doctorrepo;


@Service
public class doctorService {
@Autowired
	private doctorrepo dr;




	public responcestucture<doctor> acceptDoctor(doctor d) {
		responcestucture<doctor> rs = new responcestucture<doctor>();
	doctor dl = dr.findById(d.getId()).orElse(null);
		if(dl!=null) {
			doctor dm = dr.findById(-1).orElseThrow(()-> new allreadydoctorwasexiestonthsd() );
			
		}
	
	          if(dl != null && dl.getPlist() != null) {
                           for(Patient p : dl.getPlist()) {
	                     if(p.getId()!= 0) {
	              	 doctor pr =  dr.findById(p.getId()).orElseThrow(()-> new allreadypatientwasexistwithid() );
	                    	 
	                     }
                     }
			
		}
		 doctor saved = dr.save(d);
			rs.setStatuscode(HttpStatus.CREATED.value());	
			rs.setMasg("doctor saved sucessfully ");
			rs.setData(saved);
		return rs;
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
