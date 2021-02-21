package com.guiabolso.transaction.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.guiabolso.transaction.model.Transaction;

@SpringBootTest
public class TransactionServiceImplTest {

	@Mock
	TransactionServiceImpl service;

	@Test
	public void findAllTest() {
		List<Transaction> transaction = service.findAll("1000", 2007, 10);
		assertNotNull(transaction);
	}

}
