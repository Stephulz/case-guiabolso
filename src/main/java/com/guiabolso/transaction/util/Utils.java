package com.guiabolso.transaction.util;

import java.util.ResourceBundle;

public class Utils {

	public static String getMessage(String messageCode) {
		ResourceBundle message = ResourceBundle.getBundle("messages");
		return message.getString(messageCode);
	}

}
