package com.example.demo.es.escontroller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.es.dto.EmployeeDto;
import com.example.demo.es.service.impl.EmployeeESserviceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeEScontroller {

	private EmployeeESserviceImpl employeeService;
	
	public EmployeeEScontroller(EmployeeESserviceImpl employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/enrollment")
	public EmployeeDto insertNewEmployee(@RequestBody EmployeeDto employee) {
		return employeeService.insertNewEmployee(employee);
	}
	
	@GetMapping("/login")
	public String checkEmployeeByUsernameAndPassword(@RequestParam(name = "email") String email, @RequestParam String password) {
		return employeeService.checkEmployeeByUsernameAndPassword(email, password);
	}
	
	@GetMapping("/{id}")
	public Optional<EmployeeDto> getEmployeeDetailsById(@PathVariable String id) {
		return employeeService.getEmployeeDetailsById(id);
	}
	
	@PostMapping("/logout")
	public String employeeLogout(@RequestParam String attendanceId) throws IOException{
		return employeeService.employeeLogout(attendanceId);
	}
	
}
