package com.sanders.springdemo.domain;

public class Organization {

	private int id;
	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	private String slogan;
	
	public Organization() {
		
	}
	
	public Organization(String companyName, int yearOfIncorporation, String postalCode, int employeeCount,
			String slogan) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		this.postalCode = postalCode;
		this.employeeCount = employeeCount;
		this.slogan = slogan;
	}
	
	
	//Getters and Setters 
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
	public int getYearOfIncorporation() {
		return yearOfIncorporation;
	}
	public void setYearOfIncorporation(int yearOfIncorporation) {
		this.yearOfIncorporation = yearOfIncorporation;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	@Override
	public String toString() {
		return "Organizatipon [id=" + id + ", companyName=" + companyName + ", yearOfIncorportion"
				+ yearOfIncorporation + ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", slogan="
				+ slogan + "]";
	}
	
}
