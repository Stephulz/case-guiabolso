package com.guiabolso.transaction.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.guiabolso.transaction.exception.StandardError;

public class StandardErrorTest {

	@Test
	public void testTransaction() {
		StandardError transaction = new StandardError(1L, 400, "error", "message", "/path");
		assertEquals(Long.valueOf(1L), transaction.getTimestamp());
		assertEquals(Integer.valueOf(400), transaction.getStatus());
		assertEquals("error", transaction.getError());
		assertEquals("message", transaction.getMessage());
		assertEquals("/path", transaction.getPath());

		transaction.setTimestamp(2L);
		transaction.setStatus(404);
		transaction.setError("error1");
		transaction.setMessage("message1");
		transaction.setPath("/path1");

		assertEquals(Long.valueOf(2L), transaction.getTimestamp());
		assertEquals(Integer.valueOf(404), transaction.getStatus());
		assertEquals("error1", transaction.getError());
		assertEquals("message1", transaction.getMessage());
		assertEquals("/path1", transaction.getPath());
	}
}
