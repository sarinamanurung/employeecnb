package com.rfa.employee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rfa.employee.common.CreasionalSpesification;

@Entity
@Table(name = "cnb")
public class CNB extends CreasionalSpesification implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "payrollID", nullable = false)
	private String payrollID;
	private String payrollNotes;
	private String payrollPeriod;
	
	public CNB(String createdBy, Date createdDate, String updateBy, Date updateDate, Long id, String payrollID,
			String payrollNotes, String payrollPeriod) {
		super(createdBy, createdDate, updateBy, updateDate);
		this.id = id;
		this.payrollID = payrollID;
		this.payrollNotes = payrollNotes;
		this.payrollPeriod = payrollPeriod;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPayrollID() {
		return payrollID;
	}


	public void setPayrollID(String payrollID) {
		this.payrollID = payrollID;
	}


	public String getPayrollNotes() {
		return payrollNotes;
	}


	public void setPayrollNotes(String payrollNotes) {
		this.payrollNotes = payrollNotes;
	}


	public String getPayrollPeriod() {
		return payrollPeriod;
	}


	public void setPayrollPeriod(String payrollPeriod) {
		this.payrollPeriod = payrollPeriod;
	}



	public Object getCreationSpecification() {
		// TODO Auto-generated method stub
		return null;
	}



	public void setCreationSpecification(Object creationSpecification) {
		// TODO Auto-generated method stub
		
	}


	


	
} 