package com.qa.opencart.utils;

public class StringUtils {
	

	public static String getRandomEmailId() {
		String email = "user" + System.currentTimeMillis() + "@opencart.com";
		return email;
	}
	
	
}
