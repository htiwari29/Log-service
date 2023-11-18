package com.htiwari29.logservice.common.exceptions;

import com.htiwari29.logservice.common.errors.ErrorFactory;
import com.htiwari29.logservice.common.errors.Errors;

import java.util.Objects;

public class LogServiceException extends RuntimeException {

	private final Errors errors;

	public LogServiceException(Errors errors) {
		super(errors.getMessage());
		this.errors = assignErrors(errors);
	}

	public LogServiceException(Exception ex, Errors errors) {
		super(ex);
		this.errors = assignErrors(errors);
	}

	private Errors assignErrors(Errors errors) {
		return Objects.isNull(errors) ? ErrorFactory.createGenericError() : errors;
	}

	public Errors getErrors() {
		return errors;
	}

}
