package com.htiwari29.logservice.entrypoints;

import com.htiwari29.logservice.appservice.LogRetrievalService;
import com.htiwari29.logservice.common.responses.SuccessResponseComposer;
import com.htiwari29.logservice.domain.Log;
import com.htiwari29.logservice.entrypoints.dtos.LogFilterCriteria;
import com.htiwari29.logservice.entrypoints.validators.LogDataValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class LogRetrievalEntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogRetrievalEntryPoint.class);

	private final LogDataValidator logDataValidator;

	private final LogRetrievalService logRetrievalService;

	public LogRetrievalEntryPoint(LogDataValidator logDataValidator, LogRetrievalService logRetrievalService) {
		this.logDataValidator = logDataValidator;
		this.logRetrievalService = logRetrievalService;
	}

	@GetMapping(value = "/v1/logs")
	public Flux<Log> retrieveLogs(@RequestBody LogFilterCriteria criteria) {
		return logRetrievalService.retrieveLogs(criteria);
	}

}
