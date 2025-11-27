package com.alpha.Hospital.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.Hospital.responcestucture;


@RestControllerAdvice
public class Globalexception {
	
	
	@ExceptionHandler( doctornotfound.class)
	public responcestucture<String> doctor() {
		responcestucture<String> rs = new responcestucture<String>();
		
		
		
		rs.setStatuscode(HttpStatus.ALREADY_REPORTED.value());	
		rs.setMasg("doctor with id allready exist");
		rs.setData("doctor with id allready exist");
	
	
	return rs;
		
	}

	
	
	
	
	@ExceptionHandler( allreadydoctorwasexiestonthsd .class)
	public responcestucture<String> doctorexist() {
		responcestucture<String> rs = new responcestucture<String>();
		
		
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());	
		rs.setMasg("doctor not found");
		rs.setData("doctor  not found");
		
		return rs ;
		
	}
	
	@ExceptionHandler( allreadypatientwasexistwithid.class)
	public responcestucture<String> patientexist() {
		responcestucture<String> rs = new responcestucture<String>();
		
		
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());	
		rs.setMasg("patient  not found");
		rs.setData("patient  not found");
		
		return rs ;
		
	}
	
	
	
	
	
}
