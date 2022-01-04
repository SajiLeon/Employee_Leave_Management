package com.example.demo.es.service.api;

import com.example.demo.es.dto.EmployeeDto;

public interface EmployeeESservice {
	
	public EmployeeDto insertNewEmployee(EmployeeDto employee);
	
	public String checkEmployeeByUsernameAndPassword(String email, String password);
}
