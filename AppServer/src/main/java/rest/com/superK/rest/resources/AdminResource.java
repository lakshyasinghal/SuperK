package com.superK.rest.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.superK.requestProcessor.AdminRequestProcessor;


@Path("/api/v1")
public class AdminResource {
	private AdminRequestProcessor reqProcessor = AdminRequestProcessor.instance();
	
	@GET
	@Path("/items-info/store/{storeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemsInfoForStore(@Context HttpServletRequest req, @PathParam("storeId") int storeId) throws Exception{
		return reqProcessor.processItemsInfoForStoreRequest(storeId);
	}
	
	@GET
	@Path("/items-info/city/{cityName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemsInfoForCity(@Context HttpServletRequest req, @PathParam("cityName") String cityName) throws Exception{
		return reqProcessor.processItemsInfoForCityRequest(cityName);
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String testValue() throws Exception{
		return "Server Is Up";
	}
}
