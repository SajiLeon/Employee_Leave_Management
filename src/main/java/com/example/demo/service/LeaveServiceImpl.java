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

@Service
public class LeaveServiceImpl implements LeaveService {

	private LeaveRepository leaveRepository;
	private EmployeeRepository employeeRepository;
	private DepartmentRepository departmentRepository;
	private GroupRepository groupRepository;

	public LeaveServiceImpl(LeaveRepository leaveRepository, EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, GroupRepository groupRepository) {
		this.leaveRepository = leaveRepository;
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
		this.groupRepository = groupRepository;
	}
	
	@Override
	public LeaveEntity applyLeave(LeaveEntity leave, Integer employeeId) {
		EmployeeEntity employeeEntity = employeeRepository.getById(employeeId);
		Employee emp = new Employee();
		return leaveRepository.save(leave);
	}

//	@Override
//	public List<LeaveEntity> getLeaveStatus(Integer employeeId) {
//		EmployeeEntity employeeEntity = employeeRepository.getById(employeeId);
//		DepartmentEntity departmentEntity = departmentRepository
//				.getById(employeeEntity.getDepartment().getDepartmentId());
//		GroupEntity groupEntity = groupRepository.getById(employeeEntity.getGroup().getGroupId());
//		Employee employee = new Employee();
//
//		employee.setEmployeeId(employeeEntity.getEmployeeId());
//		employee.setEmployeeName(employeeEntity.getEmployeeName());
//		employee.setEmployeeUserName(employeeEntity.getEmployeeUserName());
//		employee.setDepartment(departmentEntity);
//		employee.setGroup(groupEntity);
//
//		List<LeaveEntity> leaveStatus = null;
//
//		Integer employeeRoleId = employee.getGroup().getGroupId();
//		Integer managerDepartmentId = employee.getDepartment().getDepartmentId();
//		Integer empManId = employee.getEmployeeManagerId();
// 		System.out.println(empManId);
// 		
// 		if (employeeRoleId == 1) {
// 			leaveStatus = leaveRepository.getAssociateDetails(employeeId);
// 		}else{
// 			leaveStatus = leaveRepository.getProjectManagerDetails(employeeId);
// 		}
// 		
//
////		if (employeeRoleId == 1) {
////			leaveStatus = leaveRepository.getAssociateDetails(employeeId);
////			System.out.println(leaveStatus);
////		} else if (employeeRoleId == 2) {
////			employeeRoleId = 1;
////			leaveStatus = leaveRepository.getProjectManagerDetails(employeeRoleId, managerDepartmentId);
////			System.out.println(leaveStatus);
////		} else {
////			employeeRoleId = 2;
////			leaveStatus = leaveRepository.getProjectManagerDetails(employeeRoleId, managerDepartmentId);
////		}
//		return leaveStatus;
//	}
	
	public List<LeaveEntity> getLeaveStatus(Integer employeeId){
		return leaveRepository.getLeaveStatusByEmployeeId(employeeId);
	}

	@Override
	public void updateLeave(Integer statusId, Integer leaveId) {
		leaveRepository.updateLeaveByLeaveId(statusId, leaveId);
		if (statusId == 3) {
			Boolean value = true;
			leaveRepository.updateLeaveCancellation(value, leaveId);
		}
	}

	@Override
	public List<LeaveEntity> getApprovalLeaves(Integer employeeId) {
		return leaveRepository.findByManagerId(employeeId);
	}

}
