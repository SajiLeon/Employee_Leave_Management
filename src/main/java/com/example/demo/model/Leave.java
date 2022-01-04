package com.example.demo.model;

import java.sql.Timestamp;

public class Leave {

	private Integer leaveId;
	private Timestamp leaveStartDate;
	private Timestamp leaveEndDate;
	private LeaveStatusEntity LeaveStatus;
	private EmployeeEntity Employee;
	private Byte leaveCancelled;
	private String leaveType;
	private Boolean leaveApplied;
	public Integer getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}
	public Timestamp getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(Timestamp leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public Timestamp getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(Timestamp leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
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
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public Boolean getLeaveApplied() {
		return leaveApplied;
	}
	public void setLeaveApplied(Boolean leaveApplied) {
		this.leaveApplied = leaveApplied;
	}


}
