package com.htiwari29.logservice.entrypoints;

import com.htiwari29.logservice.appservice.LogRetrievalService;
import com.htiwari29.logservice.entrypoints.validators.LogDataValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogRetrievalEntryPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogRetrievalEntryPoint.class);

    private final LogDataValidator logDataValidator;

    private final LogRetrievalService logRetrievalService;

    public LogRetrievalEntryPoint(LogDataValidator logDataValidator, LogRetrievalService logRetrievalService) {
        this.logDataValidator = logDataValidator;
        this.logRetrievalService = logRetrievalService;
    }
}
