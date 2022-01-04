package com.example.demo.es.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import com.example.demo.es.dto.LeaveDto;
import com.example.demo.es.repo.api.LeaveESRepo;
import com.example.demo.es.service.api.LeaveESservice;

@Service
public class LeaveESserviceImpl implements LeaveESservice{
	
	private LeaveESRepo leaveRepo;
	private RestHighLevelClient client;

	
	public LeaveESserviceImpl(LeaveESRepo leaveRepo, RestHighLevelClient client) {
		this.leaveRepo = leaveRepo;
		this.client = client;
	}

	@Override
	public String applyLeave(LeaveDto leave, String employeeId, String reportingManagerId) {
		
		leave.setEmployeeId(employeeId);
		leave.setReportingManagerId(reportingManagerId);
		LeaveDto l = leaveRepo.save(leave);
		return ("Leave Added successfully!" + l.getId());
	}

	@Override
	public List<LeaveDto> getLeaveDetails(String reportingManagerId) {
		List<LeaveDto> list = leaveRepo.findByReportingManagerId(reportingManagerId);
		return list;
	}

	@Override
	public String updateLeaveStatus(String leaveId, String leaveStatus) throws IOException {
		
		UpdateRequest request = new UpdateRequest("employee_leave_detail", leaveId).doc("leaveStatus", leaveStatus);
		UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
		return ("Leave Status updated successfully!" +updateResponse);
	}
	
	
}
