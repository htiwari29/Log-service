package com.htiwari29.logservice.appservice;

import com.htiwari29.logservice.domain.Log;
import com.htiwari29.logservice.entrypoints.dtos.LogFilterCriteria;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class LogRetrievalService {

	private final ReactiveMongoTemplate mongoTemplate;

	public LogRetrievalService(ReactiveMongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public Flux<Log> retrieveLogs(LogFilterCriteria criteria) {
		return mongoTemplate.find(criteria.createQuery(), Log.class);
	}

}
