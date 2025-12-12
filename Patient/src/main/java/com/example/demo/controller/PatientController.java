package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService ps;

	@PostMapping("add")
	public void add(@RequestBody Patient p) {
		ps.add(p);
	}

	@GetMapping("display")
	public List<Patient> display() {
		return ps.display();

	}

	@DeleteMapping("delete={id}")
	public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) throws Exception {
		ps.deleteById(id);
		Map<String, String> response = new HashMap<>();
		response.put("message", "patient is successfully delete");
		return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);

	}

	@PutMapping("update={id}")
	public Patient update(@PathVariable Integer id, @RequestBody Patient p) {
		return ps.update(id, p);
	}

	@PutMapping("findByName={name}")
	public void findByName(@PathVariable String name) {
		ps.findByName(name);
	}

	@PutMapping("findByDate={date}")
	public void findBydate(@PathVariable String date) {
		ps.findByDate(date);
	}

	@PutMapping("findByAge={age}")
	public void findByAge(@PathVariable Integer age) {
		ps.findByAge(age);
	}

	@GetMapping("findByGender={gender}")
	public ResponseEntity<?> findByGender(@PathVariable String gender) {
		return ResponseEntity.status(200).body(ps.findByGender(gender));
	}
	
	@GetMapping("sortByName")
	List<Patient> sortByName() {
		return ps.sortByName();
	}
	
	@GetMapping("sortByAge")
	List<Patient> sortByAge(){
		return ps.sortByAge();
	}
}
