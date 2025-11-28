package com.alpha.Hospital.execption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.Hospital.responcestucture;


@RestControllerAdvice
public class Globalexception {
	
	
	@ExceptionHandler( doctornotfound.class)
	public responcestucture<String> doctor() {
		responcestucture<String> rs = new responcestucture<String>();
		
		
		
		rs.setStatuscode(HttpStatus.ALREADY_REPORTED.value());	
		rs.setMasg("doctor not found");
		rs.setData("doctor not found");
	
	
	return rs;
		
	}

	
	
	
	
	@ExceptionHandler( allreadydoctorwasexiestonthsd .class)
	public responcestucture<String> doctorexist() {
		responcestucture<String> rs = new responcestucture<String>();
		
		
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());	
		rs.setMasg("doctor allredy exist in thable with this id");
		rs.setData("doctor allredy exist in thable with this id ");
		
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public responcestucture<Map<String, String>> handlemethodnotfound(MethodArgumentNotValidException ex) {
		
		Map<String,String> errormap = new HashMap<String,String>();
		List<ObjectError> objerorr = ex.getAllErrors();
		
		for (ObjectError objecterroe : objerorr) {
			
			System.err.println(objecterroe.getDefaultMessage());
			
			FieldError fr =   (FieldError) objecterroe;
			System.err.println(fr.getField());
			
			errormap.put(fr.getField(), objecterroe.getDefaultMessage());
			
		}
		
		
		responcestucture<Map<String,String> > rs = new responcestucture<Map<String,String> >();
		
		rs.setStatuscode(HttpStatus.NOT_ACCEPTABLE.value());	
		rs.setMasg("validationfailed");
		rs.setData(errormap);
		
		
		return rs;
		
	}	
	
	
	
	
	
	
	
}
