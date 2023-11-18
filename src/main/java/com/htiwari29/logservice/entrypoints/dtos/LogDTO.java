package com.htiwari29.logservice.entrypoints.dtos;

import java.time.LocalDateTime;

public class LogDTO {

	private String level;

	private String message;

	private String resourceId;

	private LocalDateTime timestamp;

	private String traceId;

	private String spanId;

	private String commit;

	private String parentResourceId;

	public String getParentResourceId() {
		return parentResourceId;
	}

	public void setParentResourceId(String parentResourceId) {
		this.parentResourceId = parentResourceId;
	}

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

}
