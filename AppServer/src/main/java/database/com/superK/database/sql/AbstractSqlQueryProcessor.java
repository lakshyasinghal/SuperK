package com.superK.database.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.superK.connectionPool.ConnectionPoolManager;
import com.superK.factory.entityFactory.EntityFactory;


public abstract class AbstractSqlQueryProcessor {
	
	public abstract <T> List<?> processReadQuery(String query , EntityFactory<T> factory) throws SQLException,Exception;
	public abstract int processDeleteQuery(String query) throws SQLException,Exception;
	public abstract int processInsertQuery(String query, boolean processInBatch) throws SQLException,Exception;
	public abstract int processUpdateQuery(String query) throws SQLException,Exception;
	
	
	protected Connection getConnection() throws SQLException,Exception{
		return ConnectionPoolManager.getConnection();
	}
	
	protected void releaseConnection(Connection conn) throws SQLException,Exception{
		try{
			ConnectionPoolManager.releaseConnection(conn);
		}
		catch(Exception ex){
			throw ex;
		}
	}
}
