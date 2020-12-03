package com.superK.factory.entityFactory;

import java.sql.ResultSet;
import java.util.List;

public interface EntityFactory<T> {
	
	public T createFromResultSet(ResultSet rs) throws Exception;
	
	public T createFromJson(String json) throws Exception;
	
	public List<T> getListFromJson(String json) throws Exception;
}
