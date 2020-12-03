package com.superK.requestProcessor;

public class ItemRequestProcessor extends AbstractRequestProcessor {
	private static ItemRequestProcessor instance = new ItemRequestProcessor();
	
	private ItemRequestProcessor() {
		
	}
	
	public static ItemRequestProcessor instance() {
		return instance;
	}
}
