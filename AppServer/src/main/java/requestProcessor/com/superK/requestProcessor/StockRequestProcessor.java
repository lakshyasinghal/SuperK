package com.superK.requestProcessor;

public class StockRequestProcessor extends AbstractRequestProcessor {
	private static StockRequestProcessor instance = new StockRequestProcessor();
	
	private StockRequestProcessor() {
		
	}
	
	public static StockRequestProcessor instance() {
		return instance;
	}
}
