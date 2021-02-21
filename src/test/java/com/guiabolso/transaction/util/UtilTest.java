package com.guiabolso.transaction.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UtilTest {

	@Test
	public void getMessageTest() {
		Utils util = new Utils();
		assertNotNull(util);
		String message = Utils.getMessage("number.format.id");
		assertNotNull(message);
	}

}
