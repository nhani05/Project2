package com.javaweb.utils;

public class StringUtil {
	public static boolean checkAttribute(String attribute) {
		if(attribute != null && !attribute.equals("")) {
			return true;
		}
		return false;
	}
	
	public static boolean isNumber(String str) {
		try {
			Long number = Long.parseLong(str);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
}
