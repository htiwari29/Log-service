package com.htiwari29.logservice.common.responses;

import com.google.gson.Gson;
import com.htiwari29.logservice.common.exceptions.LogServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FailureResponseComposer {

	private FailureResponseComposer() {
	}

	private static final Gson gson = new Gson();

	public static ResponseEntity<String> composeResponse(LogServiceException response) {
		ResponseEntity.BodyBuilder responseEntity = assignStatusCode(response);
		return responseEntity.body(gson.toJson(response.getErrors()));
	}

	private static ResponseEntity.BodyBuilder assignStatusCode(LogServiceException ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
