package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	public void findByName(String name);
	
	public void findByDate(String date);

	public void findByAge(Integer id);
	
	public void findByGender(String gender);
}
