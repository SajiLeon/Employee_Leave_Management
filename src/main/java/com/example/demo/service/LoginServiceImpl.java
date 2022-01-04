package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginRepository loginRepository;
	private AttendanceRepository attendanceRepository;
	
	public LoginServiceImpl(LoginRepository loginRepository, AttendanceRepository attendanceRepository){
		this.loginRepository = loginRepository;
		this.attendanceRepository = attendanceRepository;
	}

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
		
		Integer empId = employee.getEmployeeId();
		
		attendanceRepository.insertEmployeeId(employee.getEmployeeId());
		
		return empId.toString();
	}

	@Override
	public String logout(Integer empId) {
		attendanceRepository.updateTimeOut(empId);
		return "Logout Successfully";
	}
}
