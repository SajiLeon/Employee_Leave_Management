package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DepartmentEntity;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.ManagerEntity;

@Repository("managerRepository")
public interface ManagerRepository extends JpaRepository<ManagerEntity, Integer> {

}
