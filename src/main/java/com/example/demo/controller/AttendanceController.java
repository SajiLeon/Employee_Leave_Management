package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AttendanceEntity;
import com.example.demo.service.AttendanceService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
	private AttendanceService attendanceService;
	
	AttendanceController(AttendanceService attendanceService){
		this.attendanceService = attendanceService;
	}
	
	@PostMapping("/{employeeId}/reg-attendance")
	public ResponseEntity<?> addAttendance(@RequestBody AttendanceEntity attendance, @PathVariable Integer employeeId){
		AttendanceEntity atten = attendanceService.addAttendance(attendance, employeeId);
		return ResponseEntity.ok().body(atten);
	}
	
	@PutMapping("/logout/{employeeId}")
	public ResponseEntity<?> updateLogoutTime(@RequestBody AttendanceEntity attendance, @PathVariable Integer employeeId){
		String res = attendanceService.updateLogoutTime(attendance, employeeId);
		return ResponseEntity.ok().body(res);
	}

}
