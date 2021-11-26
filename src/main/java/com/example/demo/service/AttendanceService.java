package com.example.demo.service;

import com.example.demo.model.AttendanceEntity;

public interface AttendanceService {

	AttendanceEntity addAttendance(AttendanceEntity attendance, Integer employeeId);

	String updateLogoutTime(AttendanceEntity attendance, Integer employeeId);

}
