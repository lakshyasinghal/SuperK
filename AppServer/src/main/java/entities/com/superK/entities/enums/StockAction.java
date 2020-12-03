package com.superK.entities.enums;

public enum StockAction {
	PURCHASE(1 , "Purchase"), SALE(2 , "Sale"), RETURN_FROM_CUSTOMER(3, "Return from Customer"), RETURN_TO_WAREHOUSE_DAMAGED(4, "Damaged items returned"), 
	RETURN_TO_WAREHOUSE_EXPIRED(5, "Expired items returned");
	
	private int id;
	private String description;
	
	private StockAction(int id , String description){
		this.id = id;
		this.description = description;
	}
	
	public static StockAction valueOf(int id){
		switch(id){
		case 1:
			return PURCHASE;
		case 2:
			return SALE;
		case 3:
			return RETURN_FROM_CUSTOMER;
		case 4:
			return RETURN_TO_WAREHOUSE_DAMAGED;
		case 5:
			return RETURN_TO_WAREHOUSE_EXPIRED;
		default:
			return null;
		}
	}
	
	public int id(){
		return id;
	}
	
	public String description(){
		return description;
	}
}
