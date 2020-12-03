package com.superK.database.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.superK.factory.entityFactory.EntityFactory;

public class SqlUpdateQueryProcessor extends AbstractSqlQueryProcessor{
	private static SqlUpdateQueryProcessor queryProcessor = new SqlUpdateQueryProcessor();
	
	private SqlUpdateQueryProcessor(){
		
	}
	
	public static SqlUpdateQueryProcessor getInstance(){
		return queryProcessor;
	}
	
	
	@Override
	public <T> List<?> processReadQuery(String query, EntityFactory<T> factory)
			throws Exception {
		throw new Exception();
	}

	@Override
	public int processDeleteQuery(String query) throws Exception {
		throw new Exception();
	}

	@Override
	public int processInsertQuery(String query , boolean processInBatch) throws SQLException,Exception {
		throw new Exception();
	}

	@Override
	public int processUpdateQuery(String query) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		int rowsAffected = -1;
		try{
			SqlQueryExecutor executor = SqlQueryExecutor.getInstance();
			conn = getConnection();
			stmt = conn.createStatement();
			rowsAffected = executor.executeUpdate(stmt, query);			
			return rowsAffected;
		}
		catch(SQLException ex){
			throw ex;
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				releaseConnection(conn);
			}
		}
	}
}
