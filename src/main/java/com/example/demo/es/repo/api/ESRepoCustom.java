package com.example.demo.es.repo.api;

import com.example.demo.es.dto.AttendanceDto;

public interface ESRepoCustom {
	
	public String updateLogoutTime(AttendanceDto attendance, String timeOut);
}
