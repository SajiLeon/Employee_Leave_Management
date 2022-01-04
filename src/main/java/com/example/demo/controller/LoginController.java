package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.LoginService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class LoginController {

	private LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping("/registration")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeEntity employee) {
		loginService.addEmployee(employee);
		return ResponseEntity.ok("Registered Successfully");
	}

	@GetMapping("/login")
	public String getEmployeeDetails(@RequestParam String employeeUserName, @RequestParam String employeePassword) {
		//String msg = loginService.getEmployeeDetails(employeeUserName, employeePassword);
		return loginService.getEmployeeDetails(employeeUserName, employeePassword);
	}
	
	@GetMapping("/logout")  
    public String logout(@RequestParam Integer employeeId) {  
        return loginService.logout(employeeId);
     }  
}
