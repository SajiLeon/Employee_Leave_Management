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
@Table(name = "tbl_leave")
public class LeaveEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leave_id")
	private Integer leaveId;

	@Column(name = "leave_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date leaveDate;

	@Column(name = "leave_applied", columnDefinition = "TINYINT(1)")
	private Boolean leaveApplied;

	@ManyToOne
	@JoinColumn(name = "leave_status_id", referencedColumnName = "status_id", columnDefinition = "int default 3")
	private LeaveStatusEntity leaveStatus;

	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "emp_id")
	private EmployeeEntity employee;

	@Column(name = "leave_type")
	private String leaveType;

	@Column(name = "leave_cancelled")
	private Boolean leaveCancelled;

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
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
	
	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Boolean getLeaveCancelled() {
		return leaveCancelled;
	}

	public void setLeaveCancelled(Boolean leaveCancelled) {
		this.leaveCancelled = leaveCancelled;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

}
