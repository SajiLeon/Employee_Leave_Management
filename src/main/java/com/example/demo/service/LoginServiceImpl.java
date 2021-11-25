package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.LoginRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	public LoginRepository loginRepository;

	@Override
	public EmployeeEntity addEmployee(EmployeeEntity employee) {
		EmployeeEntity emp = loginRepository.save(employee);
		return emp;
	}

	@Override
	public String getEmployeeDetails(String EmployeeUserName, String EmployeePassword) {
		EmployeeEntity employeeEntity = loginRepository.findByEmployeeUserName(EmployeeUserName);
		if (employeeEntity == null) {
			return ("Employee does not exist");
		}
		if (!employeeEntity.getEmployeePassword().equals(EmployeePassword)) {
			return ("Password Mismatch");
		}
		Employee employee = new Employee();
		employee.setEmployeeId(employeeEntity.getEmployeeId());
		employee.setEmployeeName(employeeEntity.getEmployeeName());
		return "successfully logged in";
	}
}
