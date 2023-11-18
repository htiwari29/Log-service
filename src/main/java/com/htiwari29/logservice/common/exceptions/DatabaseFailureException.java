package com.htiwari29.logservice.common.exceptions;

import com.htiwari29.logservice.common.errors.Errors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseFailureException extends LogServiceException {

	public static final Logger log = LoggerFactory.getLogger(DatabaseFailureException.class);

	public DatabaseFailureException(Errors errors) {
		super(errors);
	}

	public DatabaseFailureException(Exception ex, Errors errors) {
		super(ex, errors);
	}

}
