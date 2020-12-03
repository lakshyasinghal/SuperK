package com.superK.exception;

public class JsonSerializationException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String message = "Exception occurred while serializing";

	public JsonSerializationException(String message){
		super(JsonSerializationException.message + "\n" + message);
	}
}
