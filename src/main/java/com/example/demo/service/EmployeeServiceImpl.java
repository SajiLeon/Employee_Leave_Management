package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.DepartmentEntity;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.GroupEntity;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.GroupRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("employeeRepository")
	public EmployeeRepository employeeRepository;

	@Autowired
	@Qualifier("departmentRepository")
	private DepartmentRepository departmentRepository;

	@Autowired
	@Qualifier("groupRepository")
	private GroupRepository groupRepository;

	@Override
	public Employee getEmployeeById(Integer employeeId) {
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

		return employee;
	}

}
