package com.example.demo.es.service.api;

import java.io.IOException;
import java.util.List;

import com.example.demo.es.dto.LeaveDto;

public interface LeaveESservice {
	
	public String applyLeave(LeaveDto leave, String employeeId, String reportingManagerId);
	public List<LeaveDto> getLeaveDetails(String reportingManagerId);
	public String updateLeaveStatus(String leaveId, String leaveStatus) throws IOException;
}
