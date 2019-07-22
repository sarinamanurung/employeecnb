package com.rfa.employee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rfa.employee.common.CreasionalSpesification;

import lombok.Data;

@Data
@Entity
@Table(name = "cnbpayroll")
public class CnbPayroll{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "payrollID", nullable = false)
	private String payrollID;
	private String payrollNotes;
	private String payrollPeriod;
	private int insentif;
	
	@Embedded
	
	private CreasionalSpesification  CreasionalSpesification;

}
	