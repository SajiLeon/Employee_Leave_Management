package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.LeaveEntity;

@Repository("leaveRepository")
public interface LeaveRepository extends JpaRepository<LeaveEntity, Object> {

	@Query("FROM LeaveEntity l where l.employee.employeeId=:employeeId")
	List<LeaveEntity> getAssociateDetails(@Param("employeeId") Integer employeeId);

	@Query("FROM LeaveEntity l where l.employee.department.departmentId=:managerDepartmentId and l.employee.group.groupId=:employeeRoleId")
	List<LeaveEntity> getProjectManagerDetails(@Param("employeeRoleId") Integer employeeRoleId,
			@Param("managerDepartmentId") Integer managerDepartmentId);

	// @Query("update LeaveHistoryEntity l set l.leaveStatus.statusId=:statusId
	// where l.employee.department.departmentId=:managerDeptId and
	// l.employee.employeeId=:employeeId")
	// List<LeaveHistoryEntity> updateLeaveStatus(@Param("statusId") Integer
	// statusId, @Param("managerDeptId") Integer managerDeptId, @Param("employeeId")
	// Integer employeeId);

	@Transactional
	@Modifying
	@Query("update LeaveEntity l set l.leaveStatus.statusId=:statusId where l.leaveId=:leaveId")
	void updateLeaveByLeaveId(@Param("statusId") Integer statusId, @Param("leaveId") Integer leaveId);

	@Transactional
	@Modifying
	@Query("update LeaveEntity l set l.leaveCancelled=:value where l.leaveId=:leaveId")
	void updateLeaveCancellation(Integer value, Integer leaveId);

}
