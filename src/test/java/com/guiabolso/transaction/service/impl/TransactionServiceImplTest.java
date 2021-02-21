package com.guiabolso.transaction.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.guiabolso.transaction.model.Transaction;

@SpringBootTest
public class TransactionServiceImplTest {

	@InjectMocks
	TransactionServiceImpl service;

	@Test
	public void findAllTest() {
		List<Transaction> transaction = service.findAll("1000", 2007, 10);
		assertNotNull(transaction);
		List<Transaction> cachedTransaction = service.findAll("1000", 2007, 10);
		assertNotNull(cachedTransaction);
	}

	@Test
	public void findAllTestYearException() {
		try {
			service.findAll("1000", 0, 10);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Insira um ano valido");
		}
	}

	@Test
	public void findAllTestMonthExceptionHigh() {
		try {
			service.findAll("1000", 2007, 13);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Insira um mes valido (01-12)");
		}
	}

	@Test
	public void findAllTestMonthExceptionLow() {
		try {
			service.findAll("1000", 2007, 0);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Insira um mes valido (01-12)");
		}
	}

	@Test
	public void findAllTestIdException() {
		try {
			service.findAll("100001", 2007, 10);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Id fora do alcance (1.000 a 100.000)");
		}
	}

	@Test
	public void findAllTestIdExceptionValid() {
		try {
			service.findAll("q", 2007, 10);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Id invalido, insira um numero inteiro entre 1.000 e 100.000");
		}
	}

	@Test
	public void findAllTestIdExceptionRange() {
		try {
			service.findAll("1", 2007, 10);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Id fora do alcance (1.000 a 100.000)");
		}
	}

}
