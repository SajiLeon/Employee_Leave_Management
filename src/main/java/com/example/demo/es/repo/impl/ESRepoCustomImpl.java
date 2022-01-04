package com.example.demo.es.repo.impl;

import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import com.example.demo.es.dto.AttendanceDto;
import com.example.demo.es.repo.api.ESRepoCustom;

public class ESRepoCustomImpl implements ESRepoCustom{
	
	private ElasticsearchRestTemplate elasticsearchRestTemplate;
	
	@Override
	public String updateLogoutTime(AttendanceDto attendance, String timeOut) {
		return null;
	}

}
