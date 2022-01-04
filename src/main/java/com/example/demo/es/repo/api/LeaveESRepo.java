package com.example.demo.es.repo.api;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.es.dto.LeaveDto;

@Repository
public interface LeaveESRepo extends ElasticsearchRepository<LeaveDto, String>{
	
	public List<LeaveDto> findByReportingManagerId(String reportingManagerId);
}
