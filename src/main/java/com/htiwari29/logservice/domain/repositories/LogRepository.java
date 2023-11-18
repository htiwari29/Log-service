package com.htiwari29.logservice.domain.repositories;

import com.htiwari29.logservice.domain.Log;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface LogRepository extends ReactiveMongoRepository<Log, String> {

	Flux<Log> findByLevel(String level);

	Flux<Log> findByMessageRegex(String message);

	Flux<Log> findByResourceId(String resourceId);

	Flux<Log> findByTimestampBetween(LocalDateTime startTime, LocalDateTime endTime);

}
