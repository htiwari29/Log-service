package com.htiwari29.logservice.entrypoints.dtos;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;

public class LogFilterCriteria {

	private String level;

	private String message;

	private String resourceId;

	private LocalDateTime timestamp;

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	private String traceId;

	private String spanId;

	private String commit;

	private String parentResourceId;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getSpanId() {
		return spanId;
	}

	public void setSpanId(String spanId) {
		this.spanId = spanId;
	}

	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}

	public String getParentResourceId() {
		return parentResourceId;
	}

	public void setParentResourceId(String parentResourceId) {
		this.parentResourceId = parentResourceId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Query createQuery() {
		Criteria filterCriteria = new Criteria();

		if (level != null) {
			filterCriteria.and("level").is(level);
		}

		if (message != null) {
			filterCriteria.and("message").regex(message);
		}

		if (resourceId != null) {
			filterCriteria.and("resourceId").is(resourceId);
		}

		if (startTime != null && endTime != null) {
			filterCriteria.and("timestamp").gte(startTime).lte(endTime);
		}
		else if (timestamp != null) {
			// Use timestamp if startTime and endTime are not provided
			filterCriteria.and("timestamp").is(timestamp);
		}

		if (traceId != null) {
			filterCriteria.and("traceId").is(traceId);
		}

		if (spanId != null) {
			filterCriteria.and("spanId").is(spanId);
		}

		if (commit != null) {
			filterCriteria.and("commit").is(commit);
		}

		if (parentResourceId != null) {
			filterCriteria.and("metadata.parentResourceId").is(parentResourceId);
		}

		return new Query(filterCriteria);
	}

}
