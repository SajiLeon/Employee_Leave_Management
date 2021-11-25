package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeEntity;

@Repository("loginRepository")
public interface LoginRepository extends JpaRepository<EmployeeEntity, Employee> {
	public List<EmployeeEntity> findByEmployeeUserNameAndEmployeePassword(String employeeUserName,
			String EmployeePassword);

	@Query("FROM EmployeeEntity e where e.employeeUserName=:employeeUserName")
	public EmployeeEntity findByEmployeeUserName(@Param("employeeUserName") String employeeUserName);
}
