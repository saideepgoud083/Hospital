package com.alpha.Hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.Hospital.responcestucture;
import com.alpha.Hospital.entity.doctor;
import com.alpha.Hospital.service.doctorService;



@RestController
public class doctorcontroller {

	@Autowired
	private doctorService ds;
	
	@PostMapping("/Doctor")
	public responcestucture<doctor> Doctor(@RequestBody doctor d) {
		
		
	return	ds.acceptDoctor(d);
		
		
	}
	
	/*********FINDDOCTOR*******/
	
	@GetMapping("/finddoctor")
	public responcestucture<doctor> findstudent(@RequestParam int id) {
		
		
		return ds.findst(id);
	}
	
	/********* DELETE DOCTOR ***********/
	@DeleteMapping("/deletdoctor")
	public responcestucture<String> deletstuden(@RequestParam int id) {
		return ds.deletstudent(id);   
	}
	
	/********* UPDATE DOCTOR ***********/
	@PutMapping("/updatedoctor")
	public responcestucture<doctor> updatestu(@RequestParam int id, @RequestParam String newname) {
		return ds.updatedoctor(id, newname);   
	}
	
	
}
