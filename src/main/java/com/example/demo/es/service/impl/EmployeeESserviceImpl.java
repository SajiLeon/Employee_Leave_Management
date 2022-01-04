package com.example.demo.es.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.es.dto.AttendanceDto;
import com.example.demo.es.dto.EmployeeDto;
import com.example.demo.es.repo.api.AttendanceESRepo;
import com.example.demo.es.repo.api.EmployeeESRepo;
import com.example.demo.es.service.api.EmployeeESservice;

@Service
public class EmployeeESserviceImpl implements EmployeeESservice{

	private EmployeeESRepo employeeRepo;
	private AttendanceESRepo attendanceRepo;
	private RestHighLevelClient client;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
	
	public EmployeeESserviceImpl(EmployeeESRepo employeeRepo, AttendanceESRepo attendanceRepo, RestHighLevelClient client) {
		this.employeeRepo = employeeRepo;
		this.attendanceRepo = attendanceRepo;
		this.client = client;
	}
	
	@Override
	public EmployeeDto insertNewEmployee(EmployeeDto employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public String checkEmployeeByUsernameAndPassword(String email, String password) {
		
		EmployeeDto employee = employeeRepo.findByEmail(email);
		if(employee == null) {
			return ("Employee does not exist");
		}
		if (!employee.getPassword().equals(password)) {
			return ("Password Mismatch");
		}

		String currentEmpId = employee.getId();
		AttendanceDto atten = null;
		if(currentEmpId != null) {
			AttendanceDto attendance = new AttendanceDto();
			attendance.setEmployeeId(currentEmpId);
			attendance.setIsPresent(true);
			attendance.setTimeIn(dtf.format(LocalDateTime.now()));
			atten = attendanceRepo.save(attendance);
		}
		
		return ("Successfully logged in!!" + employee.getId() + " " + atten.getId());
	}

	public Optional<EmployeeDto> getEmployeeDetailsById(String id) {
		return employeeRepo.findById(id);
	}

	public String employeeLogout(String attendanceId) throws IOException {
		
		UpdateRequest request = new UpdateRequest("employee_attendance", attendanceId).doc("timeOut", dtf.format(LocalDateTime.now()));
		UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
		return ("Logged Out successfully!" + updateResponse);
	};
}
