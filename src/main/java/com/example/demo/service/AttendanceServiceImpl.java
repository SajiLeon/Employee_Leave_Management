package com.example.demo.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AttendanceEntity;
import com.example.demo.repository.AttendanceRepository;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService{
	
	@Autowired
	public AttendanceRepository attendanceRepository;

	@Override
	public AttendanceEntity addAttendance(AttendanceEntity attendance, Integer employeeId) {
		return attendanceRepository.save(attendance);
	}

	@Override
	public String updateLogoutTime(AttendanceEntity attendance, Integer employeeId) {
		Date logOutTime = attendance.getTimeOut();
		attendanceRepository.updateLogoutTime(logOutTime, employeeId);
		return("Logout time updated successfully");
	}

}
