package com.superK.factory.misc;


import java.util.Map;
import com.superK.response.JsonResponse;
import com.superK.response.Response;

public class ResponseFactory {
	private static ResponseFactory factory = new ResponseFactory();
	
	private ResponseFactory(){
		
	}
	
	public static ResponseFactory instance(){
		return factory;
	}
	
	public Response getJsonResponse(boolean success , Map<String,Object> map) throws Exception{
		JsonResponse response  = new JsonResponse(success , map);
		return response;
	}
}
