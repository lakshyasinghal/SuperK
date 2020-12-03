package com.superK.factory.entityFactory;

import java.sql.ResultSet;
import java.util.List;

import com.superK.entities.Warehouse;

public class WarehouseFactory implements EntityFactory<Warehouse> {
	private static WarehouseFactory instance = new WarehouseFactory();
	
	private WarehouseFactory() {
		
	}
	
	public static WarehouseFactory instance() {
		return instance;
	}
	
	@Override
	public Warehouse createFromResultSet(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String address = rs.getString("address");
		String city = rs.getString("city");
		String state = rs.getString("state");
		return new Warehouse(id,name,address,city,state);
	}

	@Override
	public Warehouse createFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Warehouse> getListFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
