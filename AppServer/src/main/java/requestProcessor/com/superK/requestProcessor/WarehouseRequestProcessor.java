package com.superK.requestProcessor;

public class WarehouseRequestProcessor extends AbstractRequestProcessor {
 	private static WarehouseRequestProcessor instance = new WarehouseRequestProcessor();
	
	private WarehouseRequestProcessor() {
		
	}
	
	public static WarehouseRequestProcessor instance() {
		return instance;
	}
}
