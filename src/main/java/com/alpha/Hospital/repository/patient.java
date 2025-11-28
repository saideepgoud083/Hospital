package com.alpha.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.Hospital.entity.Patient;
import com.alpha.Hospital.entity.doctor;


public interface patient extends JpaRepository<Patient ,Integer> {

}
