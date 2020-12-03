package com.superK.entities.dtos;

import org.json.simple.JSONObject;

import com.superK.exception.JsonSerializationException;
import com.superK.serialization.json.JsonSerializable;

public class ItemInfoDTO implements JsonSerializable{
	private String storeName;
	private String address;
	private String city;
	private String productName;
	private int quantity;
	
	public ItemInfoDTO(String name, String address, String city, String productName, int qunatity) {
		this.storeName = name;
		this.address = address;
		this.city = city;
		this.productName = productName;
		this.quantity = qunatity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void serializeAsJson(JSONObject jo) throws JsonSerializationException {
		// TODO Auto-generated method stub
		try{
			jo.put("StoreName", storeName);
			jo.put("Address", address);
			jo.put("City", city);
			jo.put("ProductName", productName);
			jo.put("Quantity", quantity);
		}
		catch(Exception ex){
			throw new JsonSerializationException(ex.getMessage());
		}
	}
}
