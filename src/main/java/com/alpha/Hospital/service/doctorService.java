package com.alpha.Hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.Hospital.entity.doctor;
import com.alpha.Hospital.repository.doctorrepo;
@Service
public class doctorService {
@Autowired
	private doctorrepo dr;
	public void acceptDoctor(doctor d) {
		// TODO Auto-generated method stub
		dr.save(d);
	}

}
