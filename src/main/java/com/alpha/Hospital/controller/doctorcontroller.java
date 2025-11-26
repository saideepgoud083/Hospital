package com.alpha.Hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.Hospital.entity.doctor;
import com.alpha.Hospital.service.doctorService;

@RestController
public class doctorcontroller {

	@Autowired
	private doctorService ds;
	
	@PostMapping("/Doctor")
	public void Doctor(@RequestBody doctor d) {
		ds.acceptDoctor(d);
	}
	
	
}
