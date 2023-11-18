package com.htiwari29.logservice.common.responses;

import com.google.gson.Gson;
import com.htiwari29.logservice.common.exceptions.LogServiceException;
import com.htiwari29.logservice.domain.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class SuccessResponseComposer {

	private SuccessResponseComposer() {
	}

	private static final Gson gson = new Gson();

	public static ResponseEntity<String> composeResponse(Mono<Log> response) {
		return ResponseEntity.ok(gson.toJson(response));
	}

	public static Flux<ServerSentEvent<Log>> composeResponse(Flux<Log> response) {
		return response.map(log -> ServerSentEvent.<Log>builder().data(log).build())
				.delayElements(Duration.ofMillis(1000));
	}

}
