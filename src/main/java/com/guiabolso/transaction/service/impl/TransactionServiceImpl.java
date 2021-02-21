package com.guiabolso.transaction.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.guiabolso.transaction.model.Transaction;
import com.guiabolso.transaction.service.TransactionService;
import com.guiabolso.transaction.util.Constants;
import com.guiabolso.transaction.util.Utils;

@Service
public class TransactionServiceImpl implements TransactionService {

	private HashMap<String, List<Transaction>> map = new HashMap<String, List<Transaction>>();

	@Override
	public List<Transaction> findAll(String id, Integer ano, Integer mes) {
		List<Transaction> generated = generateTransactionList(id, ano, mes);
		return generated;
	}

	private List<Transaction> generateTransactionList(String id, Integer ano, Integer mes) {
		validateParams(id, ano, mes);
		StringBuilder key = new StringBuilder();
		key.append(id);
		key.append(ano);
		key.append(mes);
		String finalKey = key.toString();

		if (map.containsKey(finalKey)) {
			return map.get(finalKey);
		} else {
			Integer times = (Integer.parseInt(id.substring(0, 1)) * mes);
			List<Transaction> generatedList = new ArrayList<Transaction>();
			for (int i = 0; i < times; i++) {
				generatedList.add(generateTransaction(id, ano, mes));
			}
			map.put(finalKey, generatedList);
			return generatedList;
		}
	}

	private void validateParams(String id, Integer ano, Integer mes) {
		try {
			if (ano < 1)
				throw new NumberFormatException(Utils.getMessage("number.format.ano"));
		} catch (Exception e) {
			throw new NumberFormatException(Utils.getMessage("number.format.ano"));
		}

		try {
			if (mes < 1 || mes > 12)
				throw new NumberFormatException(Utils.getMessage("number.format.mes"));
		} catch (Exception e) {
			throw new NumberFormatException(Utils.getMessage("number.format.mes"));
		}

		try {
			Integer parsedId = Integer.parseInt(id);
			if (parsedId < 1000 || parsedId > 100000)
				throw new NumberFormatException(Utils.getMessage("number.format.id.range"));
		} catch (Exception e) {
			throw new NumberFormatException(Utils.getMessage("number.format.id"));
		}
	}

	private Transaction generateTransaction(String id, Integer ano, Integer mes) {
		Integer randomValue = ThreadLocalRandom.current().nextInt(Constants.minValue, Constants.maxValue);
		String randomDescription = generateRandomDescription(ThreadLocalRandom.current().nextInt(4, 6)).toString();
		Long randomTimestamp = generateRandomTimestamp(ano, ThreadLocalRandom.current().nextInt(0, mes));

		Transaction transaction = new Transaction(randomDescription, randomTimestamp, randomValue);
		return transaction;
	}

	private String generateRandomDescription(Integer numberOfWords) {
		StringJoiner randomStringsBuilder = new StringJoiner(" ");
		Random random = new Random();
		char[] vowels = "aeiou".toCharArray();
		char[] consoants = "bcdfghjklmnpqrstvwxyz".toCharArray();

		for (int i = 0; i < numberOfWords; i++) {
			char[] word = new char[random.nextInt(8) + 3];
			for (int j = 0; j < word.length; j++) {
				word[j] = (char) (consoants[random.nextInt(20)]);
				if (word.length > j + 1)
					word[j + 1] = (char) (vowels[random.nextInt(4)]);
				j++;
			}
			randomStringsBuilder.add(new String(word));
		}
		return randomStringsBuilder.toString();
	}

	private Long generateRandomTimestamp(Integer ano, Integer mes) {
		Calendar cld = Calendar.getInstance();
		cld.set(Calendar.YEAR, ano);
		cld.set(Calendar.MONTH, mes);
		return cld.toInstant().toEpochMilli();
	}

}
