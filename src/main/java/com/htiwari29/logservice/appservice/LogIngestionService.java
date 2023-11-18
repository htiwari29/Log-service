package com.htiwari29.logservice.appservice;

import com.htiwari29.logservice.domain.Log;
import com.htiwari29.logservice.domain.MetaData;
import com.htiwari29.logservice.entrypoints.dtos.LogDTO;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LogIngestionService {

	private final ReactiveMongoTemplate mongoTemplate;

	public LogIngestionService(ReactiveMongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public Mono<Log> ingestLog(LogDTO logDTO) {
		Log log = createLog(logDTO);
		return mongoTemplate.save(log);
	}

	private Log createLog(LogDTO logDTO) {
		return new Log(logDTO.getLevel(), logDTO.getMessage(), logDTO.getResourceId(), logDTO.getTimestamp(),
				logDTO.getTraceId(), logDTO.getSpanId(), logDTO.getCommit(),
				new MetaData(logDTO.getParentResourceId()));
	}

}
