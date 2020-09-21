package com.employee.employeemicroservice.entity;

//POJO of JobPortal
public class JobPortal {

	int id;
	String companyName;
	String designationCode;
	String salaryProvided;
	int experience;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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


