package com.guiabolso.transaction.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.guiabolso.transaction.exception.NumberValidationException;
import com.guiabolso.transaction.model.Transaction;
import com.guiabolso.transaction.service.TransactionService;
import com.guiabolso.transaction.util.Constants;
import com.guiabolso.transaction.util.Utils;

@Service
public class TransactionServiceImpl implements TransactionService {

	private HashMap<String, List<Transaction>> map = new HashMap<String, List<Transaction>>();

	@Override
	public List<Transaction> findAll(String id, Integer year, Integer month) {
		List<Transaction> generated = generateTransactionList(id, year, month);
		return generated;
	}

	private List<Transaction> generateTransactionList(String id, Integer year, Integer month) {
		validateParams(id, year, month);
		StringBuilder key = new StringBuilder();
		key.append(id);
		key.append(year);
		key.append(month);
		String finalKey = key.toString();

		if (map.containsKey(finalKey)) {
			return map.get(finalKey);
		} else {
			Integer timonth = (Integer.parseInt(id.substring(0, 1)) * month);
			List<Transaction> generatedList = new ArrayList<Transaction>();
			for (int i = 0; i < timonth; i++) {
				generatedList.add(generateTransaction(id, year, month));
			}
			map.put(finalKey, generatedList);
			return generatedList;
		}
	}

	private void validateParams(String id, Integer year, Integer month) {
		if (year < 1)
			throw new NumberFormatException(Utils.getMessage("number.format.year"));

		if (month < 1 || month > 12)
			throw new NumberFormatException(Utils.getMessage("number.format.month"));

		try {
			Integer parsedId = Integer.parseInt(id);
			if (parsedId < 1000 || parsedId > 100000)
				throw new NumberValidationException(Utils.getMessage("number.format.id.range"));
		} catch (NumberFormatException e) {
			throw new NumberFormatException(Utils.getMessage("number.format.id"));
		}
	}

	private Transaction generateTransaction(String id, Integer year, Integer month) {
		Integer randomValue = ThreadLocalRandom.current().nextInt(Constants.minValue, Constants.maxValue);
		String randomDescription = generateRandomDescription(ThreadLocalRandom.current().nextInt(4, 6)).toString();
		Long randomTimonthtamp = generateRandomTimonthtamp(year, ThreadLocalRandom.current().nextInt(0, month));

		Transaction transaction = new Transaction(randomDescription, randomTimonthtamp, randomValue);
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

	private Long generateRandomTimonthtamp(Integer year, Integer month) {
		Calendar cld = Calendar.getInstance();
		cld.set(Calendar.YEAR, year);
		cld.set(Calendar.MONTH, month);
		return cld.toInstant().toEpochMilli();
	}

}
