package com.guiabolso.transaction.exception;

public class NumberValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NumberValidationException(String msg) {
		super(msg);
	}

	public NumberValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
