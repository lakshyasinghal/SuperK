package com.superK.dao.generic;

import java.sql.SQLException;
import java.util.List;
import com.superK.entities.StoreInventory;
import com.superK.entities.dtos.ItemInfoDTO;

public interface AdminDao {
	
	public List<ItemInfoDTO> getItemsInfoForStore(int storeId) throws SQLException,Exception;

	public List<ItemInfoDTO> getItemsInfoForCity(String city) throws SQLException,Exception;
}
