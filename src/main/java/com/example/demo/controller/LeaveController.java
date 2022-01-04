package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LeaveEntity;
import com.example.demo.service.LeaveService;


@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/leave")
public class LeaveController {

	private LeaveService leaveService;
	
	public LeaveController(LeaveService leaveService) {
		this.leaveService = leaveService;
	}

	@PostMapping("/leave-apply/{employeeId}")
	public ResponseEntity<?> applyLeave(@RequestBody LeaveEntity leave, @PathVariable Integer employeeId) {
		leaveService.applyLeave(leave, employeeId);
		return ResponseEntity.ok("Leave Applied");
	}

	@GetMapping("/employees/{employeeId}/leave-status")
	public ResponseEntity<?> getLeaveStatus(@PathVariable Integer employeeId) {
		List<LeaveEntity> list = leaveService.getLeaveStatus(employeeId);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/employees/{employeeId}/reporting-employee-leave")
	public ResponseEntity<?> getApprovalLeaves(@PathVariable Integer employeeId) {
		List<LeaveEntity> list = leaveService.getApprovalLeaves(employeeId);
		return ResponseEntity.ok().body(list);
	}

	@PutMapping("/employees/leave-update")
	public ResponseEntity<?> updateLeave(@RequestParam("statusId") Integer statusId, @RequestParam("leaveId") Integer leaveId) {
		leaveService.updateLeave(statusId, leaveId);
		return ResponseEntity.ok("Leave Status updated successfully!");
	}
}
