package com.superK.factory.entityFactory;

import java.sql.ResultSet;
import java.util.List;

import com.superK.entities.Item;
import com.superK.entities.ItemType;

public class ItemTypeFactory implements EntityFactory<ItemType> {
	private static ItemTypeFactory instance = new ItemTypeFactory();
	
	private ItemTypeFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ItemTypeFactory instance() {
		return instance;
	}
	
	@Override
	public ItemType createFromResultSet(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		int id = rs.getInt("id");
		String type = rs.getString("type");
		String brand = rs.getString("brand");
		String category = rs.getString("category");
		return new ItemType(id,type,brand,category);
	}

	@Override
	public ItemType createFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemType> getListFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
