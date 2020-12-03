package com.superK.dao.sql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.superK.dao.generic.AdminDao;
import com.superK.database.sql.AbstractSqlQueryProcessor;
import com.superK.database.sql.SqlReadQueryProcessor;
import com.superK.entities.dtos.ItemInfoDTO;
import com.superK.factory.dtoFactory.ItemInfoFactory;
import com.superK.factory.entityFactory.StoreInventoryFactory;

public class AdminSqlDao implements AdminDao {
	
	@SuppressWarnings("unchecked")
	public List<ItemInfoDTO> getItemsInfoForStore(int storeId) throws SQLException, Exception {
		List<ItemInfoDTO> itemInfolist = null;
		AbstractSqlQueryProcessor queryProcessor = SqlReadQueryProcessor.getInstance();
		String query = "SELECT s.name,s.address,s.city,i.productName,si.quantity FROM Stores s JOIN StoreInventories si JOIN ItemTypes it JOIN Items i "
				+ "ON s.id=si.storeId and si.itemId=it.id and it.id=i.typeId where s.id=" + storeId;
		List<Object> list = (List<Object>) queryProcessor.processReadQuery(query,ItemInfoFactory.instance());
		if(list!=null && list.size()>0) {
			itemInfolist = new ArrayList<ItemInfoDTO>();
			for(Object obj: list) {
				itemInfolist.add((ItemInfoDTO)obj);
			}
		}
		return itemInfolist;
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemInfoDTO> getItemsInfoForCity(String city) throws SQLException, Exception {
		List<ItemInfoDTO> itemInfolist = null;
		AbstractSqlQueryProcessor queryProcessor = SqlReadQueryProcessor.getInstance();
		String query = "SELECT s.name,s.address,s.city,i.productName,si.quantity FROM Stores s JOIN StoreInventories si JOIN ItemTypes it JOIN Items i "
				+ "ON s.id=si.storeId and si.itemId=it.id and it.id=i.typeId where s.city='" + city + "'";
		List<Object> list = (List<Object>) queryProcessor.processReadQuery(query,ItemInfoFactory.instance());
		if(list!=null && list.size()>0) {
			itemInfolist = new ArrayList<ItemInfoDTO>();
			for(Object obj: list) {
				itemInfolist.add((ItemInfoDTO)obj);
			}
		}
		return itemInfolist;
	}
}
