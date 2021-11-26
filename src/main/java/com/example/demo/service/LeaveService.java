package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.LeaveEntity;

public interface LeaveService {

	public LeaveEntity applyLeave(LeaveEntity leave);

	public void updateLeave(Integer managerId, Integer statusId, Integer employeeId, Integer leaveId);

	public List<LeaveEntity> getLeaveStatus(Integer employeeId);

}
