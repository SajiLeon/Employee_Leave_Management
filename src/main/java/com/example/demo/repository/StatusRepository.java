package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LeaveStatusEntity;

@Repository("statusRepository")
public interface StatusRepository extends JpaRepository<LeaveStatusEntity, Integer> {

}
