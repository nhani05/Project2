package com.javaweb.utils;

public class StringUtil {
	public static boolean checkAttribute(Object attribute) {
		if(attribute != null) {
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
