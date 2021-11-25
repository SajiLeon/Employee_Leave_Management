package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.LeaveHistoryEntity;

public interface LeaveService {

	public LeaveHistoryEntity applyLeave(LeaveHistoryEntity leave);

	public void updateLeave(Integer managerId, Integer statusId, Integer employeeId, Integer leaveId);

	public List<LeaveHistoryEntity> getLeaveStatus(Integer employeeId);

}
