package com.superK.factory.entityFactory;

import java.sql.ResultSet;
import java.util.List;

import com.superK.entities.StoreInventory;

public class StoreInventoryFactory implements EntityFactory<StoreInventory> {
	private static StoreInventoryFactory instance = new StoreInventoryFactory();
	
	private StoreInventoryFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static StoreInventoryFactory instance() {
		return instance;
	}

	@Override
	public StoreInventory createFromResultSet(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		int id = rs.getInt("id");
		int storeId = rs.getInt("storeId");
		String itemId = rs.getString("itemId");
		int quantity = rs.getInt("quantity");
		return new StoreInventory(id,storeId,itemId,quantity);
	}

	@Override
	public StoreInventory createFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreInventory> getListFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
