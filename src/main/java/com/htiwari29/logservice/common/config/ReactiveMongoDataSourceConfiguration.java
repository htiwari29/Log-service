package com.htiwari29.logservice.common.config;

import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = { "com.htiwari29" })
public class ReactiveMongoDataSourceConfiguration extends AbstractReactiveMongoConfiguration {

	public static final Logger log = LoggerFactory.getLogger(ReactiveMongoDataSourceConfiguration.class);

	private final MongoProperties mongoProperties;

	private final Environment environment;

	public ReactiveMongoDataSourceConfiguration(MongoProperties mongoProperties, Environment environment) {
		this.mongoProperties = mongoProperties;
		this.environment = environment;
	}

	@Override
	protected String getDatabaseName() {
		return mongoProperties.getDatabase();
	}

	@Override
	public MongoClient reactiveMongoClient() {
		return MongoClients.create(
				MongoClientSettings.builder().applyConnectionString(new ConnectionString(mongoProperties.getUri()))
						.applyToConnectionPoolSettings(settings()).build());
	}

	private Block<ConnectionPoolSettings.Builder> settings() {
		// Keep in config file
		// String min =
		// environment.getProperty("threadPool.connectionPool.minimumPoolSize");
		// String max =
		// environment.getProperty("threadPool.connectionPool.maximumPoolSize");

		return builder -> {
			builder.minSize(10);
			builder.maxSize(200);
		};
	}

}
