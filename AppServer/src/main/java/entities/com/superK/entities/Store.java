package com.superK.entities;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import com.superK.exception.JsonSerializationException;
import com.superK.serialization.json.JsonSerializable;

public class Store implements JsonSerializable {
	private int id;
	private String name;
	private String address;
	private String city;
	
	public Store() {
		//nothing
	}
	
	public Store(int id, String name, String address, String city) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
	}
	
	@SuppressWarnings("unchecked")
	public void serializeAsJson(JSONObject jo) throws JsonSerializationException {
		try {
			jo.put("id", id());
			jo.put("name", name());
			jo.put("address", address());
			jo.put("city", city());
		} catch (Exception ex) {
			throw new JsonSerializationException(ex.getMessage());
		}
	}
	
	public Map<String, Object> map() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("address", address);
		map.put("city", city);

		return map;
	}
	
	//getter methods
	
	public int id() {
		return id;
	}
	
	public String name() {
		return name;
	}
	
	public String address() {
		return address;
	}
	
	public String city() {
		return city;
	}
}
