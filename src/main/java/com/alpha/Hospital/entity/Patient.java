package com.alpha.Hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	private String disease;
	private String bloodgroup;
	private int bp;
	private int sugarlevel;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public int getBp() {
		return bp;
	}
	public void setBp(int bp) {
		this.bp = bp;
	}
	public int getSugarlevel() {
		return sugarlevel;
	}
	public void setSugarlevel(int sugarlevel) {
		this.sugarlevel = sugarlevel;
	}
	public Patient(String name, int age, String disease, String bloodgroup, int bp, int sugarlevel) {
		super();
		this.name = name;
		this.age = age;
		this.disease = disease;
		this.bloodgroup = bloodgroup;
		this.bp = bp;
		this.sugarlevel = sugarlevel;
	}
	public Patient() {
		super();
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", disease=" + disease + ", bloodgroup="
				+ bloodgroup + ", bp=" + bp + ", sugarlevel=" + sugarlevel + "]";
	}
	
	
}
