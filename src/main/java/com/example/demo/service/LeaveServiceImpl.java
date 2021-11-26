package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.DepartmentEntity;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.GroupEntity;
import com.example.demo.model.LeaveEntity;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.LeaveRepository;

@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	@Qualifier("leaveRepository")
	LeaveRepository leaveRepository;

	@Autowired
	@Qualifier("employeeRepository")
	EmployeeRepository employeeRepository;

	@Autowired
	@Qualifier("departmentRepository")
	DepartmentRepository departmentRepository;

	@Autowired
	@Qualifier("groupRepository")
	GroupRepository groupRepository;

	@Override
	public LeaveEntity applyLeave(LeaveEntity leave) {
		return leaveRepository.save(leave);
	}

	@Override
	public List<LeaveEntity> getLeaveStatus(Integer employeeId) {
		EmployeeEntity employeeEntity = employeeRepository.getById(employeeId);
		DepartmentEntity departmentEntity = departmentRepository
				.getById(employeeEntity.getDepartment().getDepartmentId());
		GroupEntity groupEntity = groupRepository.getById(employeeEntity.getGroup().getGroupId());
		Employee employee = new Employee();

		employee.setEmployeeId(employeeEntity.getEmployeeId());
		employee.setEmployeeName(employeeEntity.getEmployeeName());
		employee.setEmployeeUserName(employeeEntity.getEmployeeUserName());
		employee.setDepartment(departmentEntity);
		employee.setGroup(groupEntity);

		List<LeaveEntity> leaveStatus = null;

		Integer employeeRoleId = employee.getGroup().getGroupId();
		Integer managerDepartmentId = employee.getDepartment().getDepartmentId();

		if (employeeRoleId == 1) {
			leaveStatus = leaveRepository.getAssociateDetails(employeeId);
			System.out.println(leaveStatus);
		} else if (employeeRoleId == 2) {
			employeeRoleId = 1;
			leaveStatus = leaveRepository.getProjectManagerDetails(employeeRoleId, managerDepartmentId);
			System.out.println(leaveStatus);
		} else {
			employeeRoleId = 2;
			leaveStatus = leaveRepository.getProjectManagerDetails(employeeRoleId, managerDepartmentId);
		}
		return leaveStatus;
	}

	@Override
	public void updateLeave(Integer managerId, Integer statusId, Integer employeeId, Integer leaveId) {
		leaveRepository.updateLeaveByLeaveId(statusId, leaveId);
		if (statusId == 3) {
			Integer value = 0;
			leaveRepository.updateLeaveCancellation(value, leaveId);
		}
	}

}
