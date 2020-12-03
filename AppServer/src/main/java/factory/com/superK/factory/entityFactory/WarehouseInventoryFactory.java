package com.superK.factory.entityFactory;

import java.sql.ResultSet;
import java.util.List;

import com.superK.entities.WarehouseInventory;

public class WarehouseInventoryFactory implements EntityFactory<WarehouseInventory> {
	private static WarehouseInventoryFactory instance = new WarehouseInventoryFactory();
	
	private WarehouseInventoryFactory() {
		
	}
	
	public static WarehouseInventoryFactory instance() {
		return instance;
	}

	@Override
	public WarehouseInventory createFromResultSet(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		int id = rs.getInt("id");
		int warehouseId = rs.getInt("warehouseId");
		String itemId = rs.getString("itemId");
		int quantity = rs.getInt("quantity");
		return new WarehouseInventory(id,warehouseId,itemId,quantity);
	}

	@Override
	public WarehouseInventory createFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WarehouseInventory> getListFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
