package com.example.demo.es.escontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.es.dto.LeaveDto;
import com.example.demo.es.service.impl.LeaveESserviceImpl;

@RestController
@RequestMapping("/leave")
public class LeaveEScontroller {
	
	private LeaveESserviceImpl leaveService;
	
	public LeaveEScontroller(LeaveESserviceImpl leaveService) {
		this.leaveService = leaveService;
	}
	
	@PostMapping("/apply/{employeeId}")
	public String applyLeave(@RequestBody LeaveDto leave, @PathVariable String employeeId, @RequestParam String reportingManagerId) {
		return leaveService.applyLeave(leave, employeeId, reportingManagerId);
	}
	
	@GetMapping("/employee-detail")
	public List<LeaveDto> getEmployeeLeaveDetail(@RequestParam String reportingManagerId){
		return leaveService.getLeaveDetails(reportingManagerId);
	}
	
	@GetMapping("/user-detail")
	public List<LeaveDto> getUserLeaveDetail(@RequestParam String employeeId){
		return leaveService.getLeaveDetails(employeeId);
	}
	
	@PutMapping("/leave-status-update")
	public String updateLeaveStatus(@RequestParam String leaveId, @RequestParam String leaveStatus) throws IOException {
		return leaveService.updateLeaveStatus(leaveId, leaveStatus);
	}
}
