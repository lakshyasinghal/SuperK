package com.superK.requestProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.superK.entities.dtos.ItemInfoDTO;
import com.superK.factory.misc.ResponseFactory;
import com.superK.response.Response;
import com.superK.services.entityServices.AdminService;

public class AdminRequestProcessor extends AbstractRequestProcessor {
	private static AdminRequestProcessor instance = new AdminRequestProcessor();
	private static AdminService service = new AdminService();
	private static ResponseFactory responseFactory = ResponseFactory.instance(); 
	
	private AdminRequestProcessor() {
		//nothing
	}
	
	public static AdminRequestProcessor instance() {
		return instance;
	}
	
	public String processItemsInfoForStoreRequest(int storeId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		List<ItemInfoDTO> list = null;
		boolean success = false;
		try{
			list = service.getItemsInfoForStore(storeId);
			success = true;
			map.put("list", list);
		}
		catch(Exception ex){
			throw ex;
		}
		Response response = responseFactory.getJsonResponse(success , map);
		return response.process();
	}
	
	public String processItemsInfoForCityRequest(String city) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		List<ItemInfoDTO> list = null;
		boolean success = false;
		try{
			list = service.getItemsInfoForCity(city);
			success = true;
			map.put("list", list);
		}
		catch(Exception ex){
			throw ex;
		}
		Response response = responseFactory.getJsonResponse(success , map);
		return response.process();
	}
}
