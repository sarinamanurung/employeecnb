package com.rfa.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rfa.employee.model.CNB;
import com.rfa.employee.repository.CNBRepository;

@RestController
@RequestMapping("api/v1")

public class CNBContoller {
	
	
	@Autowired
	private CNBRepository cnbRepository;
	
	@GetMapping("cnb")
	public List<CNB> getAllCnbs(){
		return cnbRepository.findAll();
		
	}
//	@PostMapping(value = "cnb/{id}")
//	
//	public ResponseEntity<CNB> update
	
	
	
	

}
