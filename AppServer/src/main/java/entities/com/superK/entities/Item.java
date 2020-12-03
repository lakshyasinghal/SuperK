package com.superK.entities;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.superK.exception.JsonSerializationException;
import com.superK.serialization.json.JsonSerializable;

public class Item implements JsonSerializable {
	private String skuId;
	private String productName;
	private int typeId; //item type id
	private float mrp;  //
	private float salesPrice;
	
	public Item() {
		//nothing
	}
	
	public Item(String skuId, String productName, int typeId, float mrp, float salesPrice) {
		this.skuId = skuId;
		this.productName = productName;
		this.typeId = typeId;
		this.mrp = mrp;
		this.salesPrice = salesPrice;
	}
	
	@SuppressWarnings("unchecked")
	public void serializeAsJson(JSONObject jo) throws JsonSerializationException {
		try{
			jo.put("skuId", skuId());
			jo.put("productName", productName());
			jo.put("typeId", typeId());
			jo.put("mrp", mrp());
			jo.put("salesPrice", salesPrice());
		}
		catch(Exception ex){
			throw new JsonSerializationException(ex.getMessage());
		}
	}
	
	
	//will return a map representation of the Item object
	//will be mostly used when inserting new Item or updating existing Item into database
	public Map<String,Object> map() throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("skuId",skuId);
		map.put("productName",productName);
		map.put("typeId",typeId);
		map.put("mrp",mrp);
		map.put("salesPrice",salesPrice);

		return map;
	}
	
	
	
	//getter methods
	
	public String skuId(){
		return skuId;
	}
	
	public String productName(){
		return productName;
	}
	
	public int typeId(){
		return typeId;
	}
	
	public float mrp(){
		return mrp;
	}
	
	public float salesPrice(){
		return salesPrice;
	}
}
