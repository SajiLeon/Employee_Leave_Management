package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.LeaveEntity;

public interface LeaveService {

	public LeaveEntity applyLeave(LeaveEntity leave, Integer employeeId);

	public void updateLeave(Integer statusId, Integer leaveId);

	public List<LeaveEntity> getLeaveStatus(Integer employeeId);

	public List<LeaveEntity> getApprovalLeaves(Integer employeeId);

}
