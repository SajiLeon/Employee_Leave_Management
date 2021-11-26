package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LeaveEntity;
import com.example.demo.service.LeaveService;

@RestController
public class LeaveController {

	@Autowired
	@Qualifier("leaveService")
	public LeaveService leaveService;

	@PostMapping("/leave-apply/{employeeId}")
	public ResponseEntity<?> applyLeave(@RequestBody LeaveEntity leave, @PathVariable Integer employeeId) {
		leaveService.applyLeave(leave);
		return ResponseEntity.ok("Leave Applied");
	}

	@GetMapping("/leave-status/{employeeId}")
	public List<LeaveEntity> getLeaveStatus(@PathVariable Integer employeeId) {
		return leaveService.getLeaveStatus(employeeId);
	}

	@PutMapping("/update-leave-status/{managerId}")
	public ResponseEntity<?> updateLeave(@PathVariable Integer managerId, @RequestParam Integer statusId,
			@RequestParam Integer employeeId, @RequestParam Integer leaveId) {
		leaveService.updateLeave(managerId, statusId, employeeId, leaveId);
		return ResponseEntity.ok("Leave Status updated successfully!");
	}
}
