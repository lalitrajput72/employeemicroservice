package com.employee.employeemicroservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOBPORTAL")
public class JobPortal {

	@Id
	int jobId;
	@Column(name="COMPANY_NAME")
	String companyName;
	@Column(name="DESGINATION_CODE")
	String designationCode;
	@Column(name="SALARY_PROVIDED")
	String salaryProvided;
	int experience;
	
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDesignationCode() {
		return designationCode;
	}
	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}
	public String getSalaryProvided() {
		return salaryProvided;
	}
	public void setSalaryProvided(String salaryProvided) {
		this.salaryProvided = salaryProvided;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
	
}
