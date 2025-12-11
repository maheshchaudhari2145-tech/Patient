package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Map<String,String>> PatientNotFoundExceptionHandler(PatientNotFoundException ex){
		 Map<String,String> response=new HashMap<>();
		 response.put("message", ex.getMessage());
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
	}

}
