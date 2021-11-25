package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_manager")
public class ManagerEntity {

	@Id
	@Column(name = "manager_id", nullable = false)
	private Integer managerId;

	@ManyToOne
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id", nullable = false)
	private EmployeeEntity Employee;

	@ManyToOne
	@JoinColumn(name = "deptment_id", referencedColumnName = "dept_id", nullable = false)
	private DepartmentEntity Department;

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public EmployeeEntity getEmployee() {
		return Employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		Employee = employee;
	}

	public DepartmentEntity getDepartment() {
		return Department;
	}

	public void setDepartment(DepartmentEntity department) {
		Department = department;
	}

}
