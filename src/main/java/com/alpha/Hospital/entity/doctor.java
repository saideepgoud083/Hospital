package com.alpha.Hospital.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Positive;
@Entity
public class doctor {
	@Id
	@Positive
private int id;
	@Length(min = 5, max = 10)
private String name;
private String specialization;
@OneToMany(cascade = CascadeType.ALL)
private List<Patient> plist;
public doctor() {
	super();
}
public doctor(int id, String name, String specialization, List<Patient> plist) {
	super();
	this.id = id;
	this.name = name;
	this.specialization = specialization;
	this.plist = plist;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;                                        
}
public String getSpecialization() {
	return specialization;
}
public void setSpecialization(String specialization) {
	this.specialization = specialization;
}
public List<Patient> getPlist() {
	return plist;
}
public void setPlist(List<Patient> plist) {
	this.plist = plist;
}
@Override
public String toString() {
	return "doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", plist=" + plist + "]";
}

	
}
