package com.superK.serialization.json;

import org.json.simple.JSONObject;


public interface JsonDeserializable {
	
	public abstract void deserializeFromJson(JSONObject jo) throws Exception;
}
