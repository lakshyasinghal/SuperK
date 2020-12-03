package com.superK.database.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.superK.factory.entityFactory.EntityFactory;

public class SqlResultProcessor {
	private static SqlResultProcessor resultProcessor = new SqlResultProcessor();
	
	private SqlResultProcessor(){
		
	}
	
	public static SqlResultProcessor getInstance(){
		return resultProcessor;
	}
	
	public <T> List<Object> process(ResultSet rs , EntityFactory<T> factory) throws SQLException , Exception{
		List<Object> entityList = new ArrayList<Object>();
		
		while(rs.next()){
			entityList.add(factory.createFromResultSet(rs));
		}
		return entityList;
	}
	
//	private List<? extends Entity> getArrayListObject(EntityType entityType){
//		List<? extends Entity> list = null;
//		if(EntityType.BOOK.equals(entityType)){
//			list = new ArrayList<Book>();
//		}
//		else if(EntityType.USER.equals(entityType)){
//			list = new ArrayList<User>();
//		}
//		return list;
//	}
}
