package com.example.demo.es.repo.api;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.es.dto.EmployeeDto;

@Repository
public interface EmployeeESRepo extends ElasticsearchRepository<EmployeeDto, String>{

	public EmployeeDto findByEmail(String email);
	
}
