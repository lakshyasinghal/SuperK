package com.superK.services.entityServices;

import java.util.List;

import com.superK.dao.generic.AdminDao;
import com.superK.dao.sql.AdminSqlDao;
import com.superK.entities.dtos.ItemInfoDTO;

public class AdminService {
	private final AdminDao dao = new AdminSqlDao();
	
	
	public List<ItemInfoDTO> getItemsInfoForStore(int storeId) throws Exception {
		return dao.getItemsInfoForStore(storeId);
	}
	
	public List<ItemInfoDTO> getItemsInfoForCity(String city) throws Exception {
		return dao.getItemsInfoForCity(city);
	}
}
