package com.htiwari29.logservice.common.responses;

import com.google.gson.Gson;
import com.htiwari29.logservice.common.exceptions.LogServiceException;
import org.springframework.http.ResponseEntity;

public class SuccessResponseComposer {

	private SuccessResponseComposer() {
	}

	private static final Gson gson = new Gson();

	public static ResponseEntity<String> composeResponse(LogServiceException response) {
		return ResponseEntity.ok(gson.toJson(response));
	}

}
