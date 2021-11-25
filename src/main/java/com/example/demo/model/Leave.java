package com.example.demo.model;

import java.sql.Timestamp;

public class Leave {

	private Integer leaveId;
	private Timestamp loginTime;
	private Timestamp logoutTime;
	private LeaveStatusEntity LeaveStatus;
	private EmployeeEntity Employee;
	private ManagerEntity Manager;
	private Byte leaveCancelled;

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Timestamp getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Timestamp logoutTime) {
		this.logoutTime = logoutTime;
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

	public ManagerEntity getManager() {
		return Manager;
	}

	public void setManager(ManagerEntity manager) {
		Manager = manager;
	}

	public Byte getLeaveCancelled() {
		return leaveCancelled;
	}

	public void setLeaveCancelled(Byte leaveCancelled) {
		this.leaveCancelled = leaveCancelled;
	}

}
