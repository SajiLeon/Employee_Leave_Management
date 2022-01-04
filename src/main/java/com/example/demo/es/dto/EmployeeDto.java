package com.example.demo.es.dto;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(indexName = "employee")
public class EmployeeDto {
	
	@Id
	private String id; 
	
	@Field(type = FieldType.Text, name = "employeeName")
	private String employeeName;
	
	@Field(type = FieldType.Text, name = "password")
	private String password;
	
	@Field(type = FieldType.Text, name = "username")
	private String username;

	@Field(type = FieldType.Text, name = "department")
	private String department;

	@Field(type = FieldType.Text, name = "role")
	private String role;
	
	@Field(type = FieldType.Text, name = "email")
	private String email;
	
	@Field(type = FieldType.Text, name = "reportingManagerId")
	private String reportingManagerId;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getReportingManagerId() {
		return reportingManagerId;
	}
	public void setReportingManagerId(String reportingManagerId) {
		this.reportingManagerId = reportingManagerId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
