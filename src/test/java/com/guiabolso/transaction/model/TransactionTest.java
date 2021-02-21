package com.guiabolso.transaction.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TransactionTest {

	@Test
	public void testTransaction() {
		Transaction transaction = new Transaction("Descrição", 1190335478675L, 9508275);
		assertEquals("Descrição", transaction.getDescricao());
		assertEquals(Long.valueOf(1190335478675L), transaction.getData());
		assertEquals(Integer.valueOf(9508275), transaction.getValor());
		transaction.setDescricao("asd");
		transaction.setData(1L);
		transaction.setValor(123);
		assertEquals("asd", transaction.getDescricao());
		assertEquals(Long.valueOf(1L), transaction.getData());
		assertEquals(Integer.valueOf(123), transaction.getValor());
	}
}
