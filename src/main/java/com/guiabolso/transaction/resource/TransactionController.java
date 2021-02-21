package com.guiabolso.transaction.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiabolso.transaction.model.Transaction;
import com.guiabolso.transaction.service.impl.TransactionServiceImpl;

@RestController
@RequestMapping
public class TransactionController {

	@Autowired
	private TransactionServiceImpl transactionService;

	@GetMapping("/{id}/transacoes/{ano}/{mes}")
	public ResponseEntity<List<Transaction>> findAllTransactions(@PathVariable String id, @PathVariable Integer ano,
			@PathVariable Integer mes) {
		List<Transaction> list = transactionService.findAll(id, ano, mes);
		return ResponseEntity.ok(list);
	}

}
