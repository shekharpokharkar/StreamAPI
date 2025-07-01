package com.seleniumexpress.streamApiExample;

import java.time.LocalDate;

public class Employee implements Comparable<Employee> {

	private Integer employeeId;
	private String employeeName;
	private String employeeDepartment;
	private String employeeCity;
	private Integer employeeAge;
	private Double employeeSalary;
	private boolean isMarried;
	private Character employeeGender;
	private LocalDate joingDateDate;

	public Employee(Integer employeeId, String employeeName, String employeeDepartment, String employeeCity,
			Integer employeeAge, Double employeeSalary, boolean isMarried, Character employeeGender,
			LocalDate joingDateDate) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
		this.employeeCity = employeeCity;
		this.employeeAge = employeeAge;
		this.employeeSalary = employeeSalary;
		this.isMarried = isMarried;
		this.employeeGender = employeeGender;
		this.joingDateDate = joingDateDate;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public Integer getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}

	public Double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public Character getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(Character employeeGender) {
		this.employeeGender = employeeGender;
	}

	public LocalDate getJoingDateDate() {
		return joingDateDate;
	}

	public void setJoingDateDate(LocalDate joingDateDate) {
		this.joingDateDate = joingDateDate;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDepartment="
				+ employeeDepartment + ", employeeCity=" + employeeCity + ", employeeAge=" + employeeAge
				+ ", employeeSalary=" + employeeSalary + ", isMarried=" + isMarried + ", employeeGender="
				+ employeeGender + ", joingDateDate=" + joingDateDate + "]";
	}

	public Employee() {

	}

	@Override
	public int compareTo(Employee e) {

		/*
		 * if (this.getEmployeeId() < e.getEmployeeId()) { return -1; } else if
		 * (this.getEmployeeId() > e.getEmployeeId()) { return 1; } else { return 0; }
		 */
		
		return 
				this.getEmployeeId() < e.getEmployeeId() ? -1 
			  : this.getEmployeeId() > e.getEmployeeId() ? 1 
			       : 0;
		

	}

}
