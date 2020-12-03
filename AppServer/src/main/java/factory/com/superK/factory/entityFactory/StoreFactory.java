package com.superK.factory.entityFactory;

import java.sql.ResultSet;
import java.util.List;

import com.superK.entities.Store;

public class StoreFactory implements EntityFactory<Store> {
	private static StoreFactory instance = new StoreFactory();
	
	private StoreFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static StoreFactory instance() {
		return instance;
	}

	@Override
	public Store createFromResultSet(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String address = rs.getString("address");
		String city = rs.getString("city");
		return new Store(id,name,address,city);
	}

	@Override
	public Store createFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Store> getListFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
