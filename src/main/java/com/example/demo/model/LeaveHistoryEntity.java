package com.example.demo.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_leave_history")
public class LeaveHistoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leave_id")
	private Integer leaveId;

	@Column(name = "login_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date loginTime;

	@Column(name = "logout_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date logoutTime;

	@Column(name = "leave_applied", columnDefinition = "TINYINT(1)")
	private Boolean leaveApplied;

	@ManyToOne
	@JoinColumn(name = "leave_status_id", referencedColumnName = "status_id", columnDefinition = "default 3")
	private LeaveStatusEntity leaveStatus;

	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "emp_id")
	@JsonIgnore
	private EmployeeEntity employee;

	// @ManyToOne
	// @JoinColumn(name = "manager_id", referencedColumnName = "manager_id")
	// private ManagerEntity manager;

	@Column(name = "leave_cancelled")
	private Boolean leaveCancelled;

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public LeaveStatusEntity getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(LeaveStatusEntity leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public Boolean getLeaveApplied() {
		return leaveApplied;
	}

	public void setLeaveApplied(Boolean leaveApplied) {
		this.leaveApplied = leaveApplied;
	}

	// public ManagerEntity getManager() {
	// return manager;
	// }
	// public void setManager(ManagerEntity manager) {
	// this.manager = manager;
	// }
	public Boolean getLeaveCancelled() {
		return leaveCancelled;
	}

	public void setLeaveCancelled(Boolean leaveCancelled) {
		this.leaveCancelled = leaveCancelled;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

}
