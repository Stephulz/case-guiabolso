package com.guiabolso.transaction.service;

import java.util.List;

import com.guiabolso.transaction.model.Transaction;

public interface TransactionService {

	public List<Transaction> findAll(String id, Integer ano, Integer mes);

}
