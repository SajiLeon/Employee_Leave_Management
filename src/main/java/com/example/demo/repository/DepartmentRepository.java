package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DepartmentEntity;

@Component
@Repository("departmentRepository")
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

}
