package com.htiwari29.logservice.entrypoints;

import com.htiwari29.logservice.appservice.LogIngestionService;
import com.htiwari29.logservice.domain.Log;
import com.htiwari29.logservice.entrypoints.dtos.LogDTO;
import com.htiwari29.logservice.entrypoints.validators.LogDataValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class LogIngestionEntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogIngestionEntryPoint.class);

	private final LogDataValidator logDataValidator;

	private final LogIngestionService logIngestionService;

	public LogIngestionEntryPoint(LogDataValidator logDataValidator, LogIngestionService logIngestionService) {
		this.logDataValidator = logDataValidator;
		this.logIngestionService = logIngestionService;
	}

	@PostMapping(value = "/v1/log")
	public Mono<Log> ingestLog(@RequestBody LogDTO logDTO) {
		return logIngestionService.ingestLog(logDTO);
	}

}
