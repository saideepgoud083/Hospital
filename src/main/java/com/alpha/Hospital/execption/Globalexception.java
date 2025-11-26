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
		
		
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());	
		rs.setMasg("doctor with not found");
		rs.setData("doctor with not found");
		
		return rs ;
		
	}

}
