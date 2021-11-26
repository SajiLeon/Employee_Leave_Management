package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeEntity;

public interface LoginService {
	public EmployeeEntity addEmployee(EmployeeEntity employee);

	public String getEmployeeDetails(String employeeUserName, String employeePassword);

	public String logout();
}
