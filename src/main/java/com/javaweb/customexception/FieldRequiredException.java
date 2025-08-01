package com.javaweb.customexception;

// sử dụng RuntimeException không cần throws 

public class FieldRequiredException extends RuntimeException {

	public FieldRequiredException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
