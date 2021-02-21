package com.guiabolso.transaction.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ConstantsTest {

	@Test
	public void constantsTest() {
		Constants constants = new Constants();
		assertEquals(Integer.valueOf(9999999), Constants.maxValue);
		assertEquals(Integer.valueOf(-9999999), Constants.minValue);
		assertNotNull(constants);
	}
}
