package com.superK.serialization.json;

import org.json.simple.JSONObject;

//import org.json.simple.JSONObject;
import com.superK.exception.JsonSerializationException;

public interface JsonSerializable {
	
	public void serializeAsJson(JSONObject jo) throws JsonSerializationException;
} 
