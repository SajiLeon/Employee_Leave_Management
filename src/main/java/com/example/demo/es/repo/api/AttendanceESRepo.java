package com.example.demo.es.repo.api;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.es.dto.AttendanceDto;

@Repository
public interface AttendanceESRepo extends ElasticsearchRepository<AttendanceDto, String>{

}
