package com.rfa.employee.controller;

import java.util.ArrayList;
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
import com.rfa.employee.model.CnbPayroll;
import com.rfa.employee.repository.CnbPayrollRepository;

@RestController
@RequestMapping("api/v2")
public class CnbPayrollContoller {
	
	
	@Autowired
	CnbPayrollRepository cnbPayrollRepository;
	
	@GetMapping("cnb")
	public List<CnbPayroll> getAllCnbPayroll() {
	
//		List<CnbPayroll> cnbPayrollList= new ArrayList<>();
//		cnbPayrollRepository.findAll().forEach(System.out::println);
		return cnbPayrollRepository.findAll();
		
		
	}
	@PostMapping(value = "/cnbsave")
	public CnbPayroll save(@RequestBody CnbPayroll cnbPayroll) {
		CnbPayroll result = new CnbPayroll();
		result.setId(cnbPayroll.getId());
		result.setCreasionalSpesification(cnbPayroll.getCreasionalSpesification());
		result.setInsentif(cnbPayroll.getInsentif());
		result.setPayrollID(cnbPayroll.getPayrollID());
		result.setPayrollNotes(cnbPayroll.getPayrollNotes());
		result.setPayrollPeriod(cnbPayroll.getPayrollPeriod());
		System.out.println(result);
		return cnbPayrollRepository.save(result);
	
	}
	@PutMapping(value = "/cnb/{id}") 
	public ResponseEntity<CnbPayroll>UpdatecnbPayroll(@Valid @RequestBody CnbPayroll cnbPayrollRequest, @PathVariable(value = "id") Long cnbpayrollId) throws DataNotFoundException {
		CnbPayroll cnbPayroll = cnbPayrollRepository.findById(cnbpayrollId)
				.orElseThrow(() -> new DataNotFoundException("Employee not found for this id ::" + cnbpayrollId));
		
		cnbPayroll.setPayrollID(cnbPayrollRequest.getPayrollID());
		cnbPayroll.setPayrollNotes(cnbPayrollRequest.getPayrollNotes());
		cnbPayroll.setPayrollPeriod(cnbPayrollRequest.getPayrollPeriod());
		cnbPayroll.setInsentif(cnbPayrollRequest.getInsentif());
		cnbPayroll.setCreasionalSpesification(cnbPayrollRequest.getCreasionalSpesification());
		
		final CnbPayroll updateCnbPayroll= cnbPayrollRepository.save(cnbPayroll);
		
	return ResponseEntity.ok().body(updateCnbPayroll);
	}
	@DeleteMapping("/cnb/{id}")
	public Map<String, Boolean> deleteCnbPayroll(@PathVariable(value = "id") Long cnbPayrollId)
		throws DataNotFoundException {
		CnbPayroll cnbPayroll = cnbPayrollRepository.findById(cnbPayrollId)
				.orElseThrow(() -> new DataNotFoundException("Employee not found for this id ::" + cnbPayrollId));
		
		cnbPayrollRepository.delete(cnbPayroll);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
	return response;
	}
	
	

}
