package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer employeeId;

	@Column(name = "emp_name")
	private String employeeName;

	@Column(name = "emp_password")
	private String employeePassword;

	@Column(name = "emp_username")
	private String employeeUserName;

	@ManyToOne
	@JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
	private DepartmentEntity department;

	@ManyToOne
	@JoinColumn(name = "group_id", referencedColumnName = "group_id")
	private GroupEntity group;
	
	@Column(name = "reporting_manager_id")
	private Integer employeeManagerId;

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

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeUserName() {
		return employeeUserName;
	}

	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public GroupEntity getGroup() {
		return group;
	}

	public void setGroup(GroupEntity group) {
		this.group = group;
	}

	public Integer getEmployeeManagerId() {
		return employeeManagerId;
	}

	public void setEmployeeManagerId(Integer employeeManagerId) {
		this.employeeManagerId = employeeManagerId;
	}

}
