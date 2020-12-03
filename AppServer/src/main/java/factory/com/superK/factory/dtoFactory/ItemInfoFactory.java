package com.superK.factory.dtoFactory;

import java.sql.ResultSet;
import java.util.List;
import com.superK.entities.dtos.ItemInfoDTO;
import com.superK.factory.entityFactory.EntityFactory;

public class ItemInfoFactory implements EntityFactory<ItemInfoDTO> {
	private static ItemInfoFactory instance = new ItemInfoFactory();
	
	private ItemInfoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ItemInfoFactory instance() {
		return instance;
	}

	@Override
	public ItemInfoDTO createFromResultSet(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		String storeName = rs.getString("name");
		String address = rs.getString("address");
		String city = rs.getString("city");
		String productName = rs.getString("productName");
		int quantity = rs.getInt("quantity");
		return new ItemInfoDTO(storeName,address,city,productName,quantity);
	}

	@Override
	public ItemInfoDTO createFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemInfoDTO> getListFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
