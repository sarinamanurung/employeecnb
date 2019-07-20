package com.rfa.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rfa.employee.exception.DataNotFoundException;
import com.rfa.employee.model.Division;
import com.rfa.employee.repository.DivisionRepository;

@RestController
@RequestMapping(value = "/api/v1")
public class DivisionController {

	@Autowired
	private DivisionRepository divisionRepository;
	
	@GetMapping("/div")
	public List<Division> GetAllDivision(){
		return divisionRepository.findAll();
		
	}
	
	@GetMapping(value = "/div/{id}")
	public ResponseEntity<Division> GetDivisionById(@PathVariable(value = "id") Long divisionId) throws DataNotFoundException{
		
		Division division = divisionRepository.findById(divisionId)
				.orElseThrow(() -> new DataNotFoundException("Division not found for this id :: " + divisionId));
		
		return ResponseEntity.ok().body(division);
		
	}
	
	@PostMapping(value = "/div")
	public Division InsertDivision(@Valid @RequestBody Division division) {
		return divisionRepository.save(division);
	}
	
	@PutMapping(value = "/div/{id}")
	public ResponseEntity<Division> UpdateDivision(@PathVariable(value = "id") Long divisionId, @Valid @RequestBody Division divisionRequest) throws DataNotFoundException {
		
		Division division = divisionRepository.findById(divisionId)
				.orElseThrow(() -> new DataNotFoundException("Division not found for this id :: " + divisionId));
		
		division.setName(divisionRequest.getName());
		
		final Division updateDivision = divisionRepository.save(division);
		
		return ResponseEntity.ok().body(updateDivision);
		
	}
	
	@DeleteMapping(value = "/div/{id}")
	public Map<String, Boolean> deleteDivision(@PathVariable(value = "id") Long divisionId) throws DataNotFoundException{
		
		Division division = divisionRepository.findById(divisionId)
				.orElseThrow(() -> new DataNotFoundException("Division not found for this id :: "+ divisionId));
		
		divisionRepository.delete(division);
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
		
		
	}
	
	
}
