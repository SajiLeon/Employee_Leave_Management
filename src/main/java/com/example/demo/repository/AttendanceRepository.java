package com.example.demo.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.AttendanceEntity;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Integer>{

	@Transactional
	@Modifying
	@Query("update AttendanceEntity a set a.timeOut=:timeOut where a.employee.employeeId=:employeeId")
	void updateLogoutTime(@Param("timeOut") Date timeOut, @Param("employeeId") Integer employeeId);

	@Transactional
	@Modifying
	@Query(value = "insert into tbl_attendance (time_in,employee_id, present_or_leave) values(now(), :employeeId, 1)", nativeQuery = true)
	void insertEmployeeId(@Param("employeeId") Integer employeeId);

	@Transactional
	@Modifying
	@Query("update AttendanceEntity a set a.timeOut=now() where a.employee.employeeId=:employeeId")
	void updateTimeOut(@Param("employeeId") Integer employeeId);

}
