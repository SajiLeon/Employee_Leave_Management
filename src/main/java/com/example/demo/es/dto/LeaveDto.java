package com.example.demo.es.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "employee_leave_detail")
public class LeaveDto {

	@Id
	private String id;
	
	private String leaveStartDate;
	private String leaveEndDate;
	private String leaveStatus;
	private String leaveType;
	private Boolean isLeaveApproved;
	private String employeeId;
	private String reportingManagerId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(String leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public String getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(String leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public Boolean getIsLeaveApproved() {
		return isLeaveApproved;
	}
	public void setIsLeaveApproved(Boolean isLeaveApproved) {
		this.isLeaveApproved = isLeaveApproved;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getReportingManagerId() {
		return reportingManagerId;
	}
	public void setReportingManagerId(String reportingManagerId) {
		this.reportingManagerId = reportingManagerId;
	}
	
	
}
