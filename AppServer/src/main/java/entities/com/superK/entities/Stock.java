package com.superK.entities;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.superK.entities.enums.StockAction;
import com.superK.exception.JsonSerializationException;
import com.superK.serialization.json.JsonSerializable;

public class Stock implements JsonSerializable {
	private int id;
	private String itemId;
	private int storeId;
	private int quantChange;
	private StockAction action;
	
	public Stock() {
		// nothing
	}

	public Stock(int id, String itemId, int storeId, int quantChange, StockAction action) {
		this.id = id;
		this.itemId = itemId;
		this.storeId = storeId;
		this.quantChange = quantChange;
		this.action = action;
	}

	@SuppressWarnings("unchecked")
	public void serializeAsJson(JSONObject jo) throws JsonSerializationException {
		try {
			jo.put("id", id());
			jo.put("itemId", itemId());
			jo.put("storeId", storeId());
			jo.put("quantChange", quantChange());
			jo.put("action", action.description());
		} catch (Exception ex) {
			throw new JsonSerializationException(ex.getMessage());
		}
	}

	// will return a map representation of the Stock object
	// will be mostly used when inserting new Stock or updating existing Stock into database
	public Map<String, Object> map() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("itemId", itemId);
		map.put("quantChange", quantChange);
		map.put("storeId", storeId);
		map.put("action",action.id());
		return map;
	}

	// getter methods

	public int id() {
		return id;
	}

	public String itemId() {
		return itemId;
	}
	
	public int storeId() {
		return storeId;
	}

	public int quantChange() {
		return quantChange;
	}
	
	public StockAction action() {
		return action;
	}
}
