package com.superK.factory.entityFactory;

import java.sql.ResultSet;
import java.util.List;

import com.superK.entities.Item;

public class ItemFactory implements EntityFactory<Item>{
	private static ItemFactory itemFactory;
	
	private ItemFactory() {
		//nothing
	}
	
	public static ItemFactory instance() {
		try{
			if(itemFactory ==  null){
				synchronized(ItemFactory.class){
					if(itemFactory ==  null){
						itemFactory = new ItemFactory();
					}
				}
			}
			
			return itemFactory;
		}
		catch(Exception ex){
			throw ex;
		}
	}

	@Override
	public Item createFromResultSet(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		String skuId = rs.getString("skuId");
		String productName = rs.getString("productName");
		int typeId = rs.getInt("typeId");
		float mrp = rs.getFloat("mrp");
		float salesPrice = rs.getFloat("salesPrice");
		return new Item(skuId,productName,typeId,mrp,salesPrice);
	}

	@Override
	public Item createFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getListFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
