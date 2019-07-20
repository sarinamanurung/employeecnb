package com.rfa.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rfa.employee.exception.DataNotFoundException;
import com.rfa.employee.model.CNB;
import com.rfa.employee.model.Employee;
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
	@PostMapping(value = "cnb/{id}")
	public CNB save(@RequestBody CNB cnb) {
		return cnbRepository.save(cnb);
	
	}
	@PutMapping(value = "cnb/{id}") 
	public ResponseEntity<CNB>UpdateCNB(@Valid @RequestBody CNB cnbRequest, @PathVariable(value = "id") Long cnbId) throws DataNotFoundException {
		CNB cnb = cnbRepository.findById(cnbId)
				.orElseThrow(() -> new DataNotFoundException("Employee not found for this id ::" + cnbId));
		
		cnb.setPayrollID(cnbRequest.getPayrollID());
		cnb.setPayrollNotes(cnbRequest.getPayrollNotes());
		cnb.setPayrollPeriod(cnbRequest.getPayrollPeriod());
		cnb.setCreationSpecification(cnbRequest.getCreationSpecification());
		
		final CNB updateCNB = cnbRepository.save(cnb);
		
	return ResponseEntity.ok().body(updateCNB);
	}
	
	

}
