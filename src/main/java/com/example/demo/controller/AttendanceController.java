package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AttendanceEntity;
import com.example.demo.service.AttendanceService;

@RestController
public class AttendanceController {
	
	@Autowired
	public AttendanceService attendanceService;
	
	@PostMapping("/addattendance/{employeeId}")
	public ResponseEntity<?> addAttendance(@RequestBody AttendanceEntity attendance, @PathVariable Integer employeeId){
		AttendanceEntity atten = attendanceService.addAttendance(attendance, employeeId);
		return ResponseEntity.ok().body(atten);
	}
	
	@PutMapping("/updatetimeout/{employeeId}")
	public ResponseEntity<?> updateLogoutTime(@RequestBody AttendanceEntity attendance, @PathVariable Integer employeeId){
		String res = attendanceService.updateLogoutTime(attendance, employeeId);
		return ResponseEntity.ok().body(res);
	}

}
