package com.superK.entities;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.superK.exception.JsonSerializationException;
import com.superK.serialization.json.JsonSerializable;

public class WarehouseInventory implements JsonSerializable {
	private int id;
	private int warehouseId;
	private String itemId;
	private int quantity;
	
	public WarehouseInventory() {
		//nothing
	}
	
	public WarehouseInventory(int id, int warehouseId, String itemId, int quantity) {
		this.id = id;
		this.warehouseId = warehouseId;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	@SuppressWarnings("unchecked")
	public void serializeAsJson(JSONObject jo) throws JsonSerializationException {
		try {
			jo.put("id", id());
			jo.put("warehouseId", warehouseId());
			jo.put("itemId", itemId());
			jo.put("quantity", quantity());
		} catch (Exception ex) {
			throw new JsonSerializationException(ex.getMessage());
		}
	}
	
	public Map<String, Object> map() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("warehouseId", warehouseId);
		map.put("itemId", itemId);
		map.put("quantity", quantity);

		return map;
	}
	
	//getter methods
	
	public int id() {
		return id;
	}
	
	public int warehouseId() {
		return warehouseId;
	}
	
	public String itemId() {
		return itemId;
	}
	
	public int quantity() {
		return quantity;
	}
}
