package com.guiabolso.transaction.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.guiabolso.transaction.exception.NumberValidationException;

public class NumberValidationExceptionTest {

	@Test
	public void testTransaction() {
		NumberValidationException transaction = new NumberValidationException("message");
		assertEquals("message", transaction.getMessage());
		NumberValidationException transactionConstructor = new NumberValidationException("message", new Throwable());
		assertEquals("message", transactionConstructor.getMessage());
	}
}
