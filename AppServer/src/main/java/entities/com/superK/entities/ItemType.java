package com.superK.entities;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.superK.exception.JsonSerializationException;
import com.superK.serialization.json.JsonSerializable;

public class ItemType implements JsonSerializable {
	private int id;
	private String type;
	private String brand;
	private String category;

	public ItemType() {
		// nothing
	}

	public ItemType(int id, String type, String brand, String category) {
		this.id = id;
		this.type = type;
		this.brand = brand;
		this.category = category;
	}

	@SuppressWarnings("unchecked")
	public void serializeAsJson(JSONObject jo) throws JsonSerializationException {
		try {
			jo.put("id", id());
			jo.put("type", type());
			jo.put("brand", brand());
			jo.put("category", category());
		} catch (Exception ex) {
			throw new JsonSerializationException(ex.getMessage());
		}
	}

	// will return a map representation of the ItemType object
	// will be mostly used when inserting new book or updating existing ItemType into database
	public Map<String, Object> map() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("type", type);
		map.put("brand", brand);
		map.put("category", category);

		return map;
	}

	// getter methods

	public int id() {
		return id;
	}

	public String type() {
		return type;
	}

	public String brand() {
		return brand;
	}

	public String category() {
		return category;
	}
}
