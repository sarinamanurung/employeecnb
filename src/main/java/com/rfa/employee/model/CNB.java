package com.rfa.employee.model;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rfa.employee.common.CreasionalSpesification;

@Entity
@Table(name = "cnb")

public class CNB  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String payrollID;
	private String payrollNotes;
	private String payrollPeriod;
	
	
	@Embedded
	private CreasionalSpesification creationSpecification;
	
} 