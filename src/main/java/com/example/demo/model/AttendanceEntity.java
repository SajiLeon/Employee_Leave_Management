package com.example.demo.model;

import java.sql.Date;

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
@Table(name = "tbl_attendance")
public class AttendanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendance_id")
	private Integer attendanceId;

	@Column(name = "time_in", columnDefinition = "timestamp default now()")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date timeIn;

	@Column(name = "time_out")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date timeOut;
	
	@Column(name = "present_or_leave")
	private Boolean presentOrLeave;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "emp_id")
	private EmployeeEntity employee;

	public Integer getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Date getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}

	public Boolean getPresentOrLeave() {
		return presentOrLeave;
	}

	public void setPresentOrLeave(Boolean presentOrLeave) {
		this.presentOrLeave = presentOrLeave;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
	
	
}
