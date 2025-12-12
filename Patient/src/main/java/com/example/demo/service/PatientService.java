package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Patient;

public interface PatientService {
	void add(Patient p);

	List<Patient> display();

	Patient update(Integer id, Patient p);

	void deleteById(Integer id) throws Exception;
	
	void findByName(String name);
	
	void findByDate(String date);
	
	public void findByAge(Integer age);
	
	public List<Patient> findByGender(String gender);

	List<Patient> sortByName();
	
	List<Patient> sortByAge();
	
	
}
