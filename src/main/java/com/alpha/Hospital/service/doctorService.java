package com.alpha.Hospital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.Hospital.responcestucture;
import com.alpha.Hospital.dto.patientdto;
import com.alpha.Hospital.entity.Patient;
import com.alpha.Hospital.entity.doctor;
import com.alpha.Hospital.execption.allreadydoctorwasexiestonthsd;
import com.alpha.Hospital.execption.allreadypatientwasexistwithid;
import com.alpha.Hospital.execption.doctornotfound;
import com.alpha.Hospital.repository.doctorrepo;
import com.alpha.Hospital.repository.patient;


@Service
public class doctorService {
@Autowired
	private doctorrepo dr;
@Autowired
private patient pr ;


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
	
	
	
	
	
	public responcestucture<doctor> findst(int id) {
		// TODO Auto-generated method stub
		doctor d = dr.findById(id).orElseThrow(()-> new doctornotfound() );
		responcestucture<doctor> rs = new responcestucture<doctor>();
		
			
		rs.setStatuscode(HttpStatus.FOUND.value());	
		rs.setMasg("doctor with id "+id+"found");
		rs.setData(d);
	
	
	return rs;
	}

	
	
	public responcestucture<String> deletstudent(int id) {
		
		doctor d = dr.findById(id).orElseThrow(() -> new doctornotfound());
		
		dr.delete(d);
		
		responcestucture<String> rs = new responcestucture<String>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMasg("doctor deleted successfully with id " + id);
		rs.setData("deleted");
		
		return rs;
	}

	/***************UPDATING DOCTOR************/
	public responcestucture<doctor> updatedoctor(int id, String newname) {
		
		doctor d = dr.findById(id).orElseThrow(() -> new doctornotfound());
		
		d.setName(newname);
		
		doctor updated = dr.save(d);
		
		responcestucture<doctor> rs = new responcestucture<doctor>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMasg("doctor updated successfully with id " + id);
		rs.setData(updated);
		
		return rs;
	}





	public void savepdto(patientdto pdto) {
		 
		
	
		Patient p = new Patient ();
		 p.setName(pdto.getName());
		 p.setAge(pdto.getAge());
		 p.setDisease(pdto.getDisease());
		 pr.save(p);
	
		
		
	}
	
	
	

	
	
	

}
