package com.example.demo.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository pr;

	@Override
	public void add(Patient p) {
		// TODO Auto-generated method stub
		pr.save(p);

	}

	@Override
	public List<Patient> display() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Patient update(Integer id, Patient p) {
		// TODO Auto-generated method stub
		p.setId(id);
		return pr.save(p);
	}

	@Override
	public void deleteById(Integer id) throws Exception {

		Patient patient = this.pr.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("patient not found with give id"));
		// TODO Auto-generated method stub
		pr.delete(patient);

	}

	@Override
	public void findByName(String name) {
		pr.findByName(name);
	}

	@Override
	public void findByDate(String date) {
		// TODO Auto-generated method stub
		pr.findByDate(date);
	}

	@Override
	public void findByAge(Integer id) {
		// TODO Auto-generated method stub
		pr.findByAge(id);

	}

	@Override
	public List<Patient> findByGender(String gender) {
		// TODO Auto-generated method stub
		return pr.findByGender(gender);
	}

	@Override
	public List<Patient> sortByName() {
		// TODO Auto-generated method stub
		List<Patient> list = pr.findAll();

		Collections.sort(list, new Comparator<Patient>() {
			public int compare(Patient o1, Patient o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return list;
	}

	@Override
	public List<Patient> sortByAge() {
		// TODO Auto-generated method stub
		List <Patient> list = pr.findAll();
		list.sort((p1,p2) -> p1.getAge().compareTo(p2.getAge()));
		
		return list;
	}	

}
