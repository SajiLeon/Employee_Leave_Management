package com.example.demo.model;

import java.sql.Timestamp;

public class Leave {

	private Integer leaveId;
	private Timestamp leaveDate;
	private LeaveStatusEntity LeaveStatus;
	private EmployeeEntity Employee;
	private Byte leaveCancelled;

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Timestamp getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Timestamp leaveDate) {
		this.leaveDate = leaveDate;
	}

	public LeaveStatusEntity getLeaveStatus() {
		return LeaveStatus;
	}

	public void setLeaveStatus(LeaveStatusEntity leaveStatus) {
		LeaveStatus = leaveStatus;
	}

	public EmployeeEntity getEmployee() {
		return Employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		Employee = employee;
	}

	public Byte getLeaveCancelled() {
		return leaveCancelled;
	}

	public void setLeaveCancelled(Byte leaveCancelled) {
		this.leaveCancelled = leaveCancelled;
	}

}
