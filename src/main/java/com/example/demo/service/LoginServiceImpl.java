package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.LoginRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	public LoginRepository loginRepository;
	
	@Autowired
	public AttendanceRepository attendanceRepository;

	@Override
	public EmployeeEntity addEmployee(EmployeeEntity employee) {
		EmployeeEntity emp = loginRepository.save(employee);
		return emp;
	}
	

	Employee employee = new Employee();

	@Override
	public String getEmployeeDetails(String EmployeeUserName, String EmployeePassword) {
		EmployeeEntity employeeEntity = loginRepository.findByEmployeeUserName(EmployeeUserName);
		if (employeeEntity == null) {
			return ("Employee does not exist");
		}
		if (!employeeEntity.getEmployeePassword().equals(EmployeePassword)) {
			return ("Password Mismatch");
		}
		employee.setEmployeeId(employeeEntity.getEmployeeId());
		employee.setEmployeeName(employeeEntity.getEmployeeName());
		
		attendanceRepository.insertEmployeeId(employee.getEmployeeId());
		
		return "successfully logged in";
	}

	@Override
	public String logout() {
		employee.setEmployeeId(12);
		Integer empId = employee.getEmployeeId();
		attendanceRepository.updateTimeOut(empId);
		return null;
	}
}
