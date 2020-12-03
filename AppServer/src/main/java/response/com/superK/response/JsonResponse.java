package com.superK.response;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import com.superK.exception.JsonSerializationException;
import com.superK.serialization.json.JsonSerializable;
import com.superK.util.JsonUtility;



public class JsonResponse implements Response {
	private static final Logger LOGGER = Logger.getLogger(JsonResponse.class.getName());
	private final boolean success;
	//private final int statusCode;
	//private final int errorCode;
	//private final List<? extends Entity> list;
	private final Map<String,Object> map;
	
	public JsonResponse(){
		success = false;
		//statusCode = -1;
		//errorCode = -1;
		map = null;
	}
	
	public JsonResponse(boolean success , Map<String,Object> map){
		this.success = success;
		//this.statusCode = statusCode;
		//this.errorCode = errorCode;
		this.map = map;
	}
	
	public String process() throws Exception {
		try{
			String json = serializeAsJson();
			return json;
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String serializeAsJson() throws JsonSerializationException {
		try{
			String jsonStr = null;
			JSONObject jo = new JSONObject();
			jo.put("success", success);
			//jo.put("statusCode", statusCode);
			//jo.put("errorCode", errorCode);
			
			//jo.put("list", getSerializedList());
			//iterate over the map using key set and insert key and serialized value in JSON map 
			if(map!=null){
				for(String key : map.keySet()){
					Object obj = map.get(key);
					if(obj instanceof JsonSerializable){
						jo.put(key, JsonUtility.getJSONObjFromObj((JsonSerializable)obj));
					}
					else if(obj instanceof List){
						jo.put(key, JsonUtility.getJsonArrayFromList((List<JsonSerializable>)obj));
					}
					else if(obj instanceof String || obj instanceof Integer){
						jo.put(key, obj);
					}
					else{
						jo.put(key, obj);
					}
				}
			}
			
			jsonStr = jo.toJSONString();
			LOGGER.info(jsonStr);
			return jsonStr;
		}
		catch(Exception ex){
			throw new JsonSerializationException(ex.getMessage());
		}
	}
	
}
