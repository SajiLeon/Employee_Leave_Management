package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	@Qualifier("loginService")
	public LoginService loginService;

	@PostMapping("/registration")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeEntity employee) {
		loginService.addEmployee(employee);
		return ResponseEntity.ok("Registered Successfully");
	}

	@GetMapping("/login")
	public String getEmployeeDetails(@RequestParam String employeeUserName, @RequestParam String employeePassword) {
		return loginService.getEmployeeDetails(employeeUserName, employeePassword);
	}
}
