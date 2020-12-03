package com.superK.factory.entityFactory;

import java.sql.ResultSet;
import java.util.List;

import com.superK.entities.Stock;
import com.superK.entities.enums.StockAction;

public class StockFactory implements EntityFactory<Stock>{
private static StockFactory instance = new StockFactory();
	
	private StockFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static StockFactory instance() {
		return instance;
	}

	@Override
	public Stock createFromResultSet(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		int id = rs.getInt("id");
		String itemId = rs.getString("itemId");
		int storeId = rs.getInt("storeId");
		int quantChange = rs.getInt("quantChange");
		StockAction action = StockAction.valueOf(rs.getInt("action"));
		return new Stock(id,itemId,storeId,quantChange,action);
	}

	@Override
	public Stock createFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stock> getListFromJson(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
