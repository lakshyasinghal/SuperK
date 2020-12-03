package com.superK.database.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.superK.factory.entityFactory.EntityFactory;


//The role of SqlReadQueryProcessor and other similar classes will be to first execute the query and then return the processed result set
public class SqlReadQueryProcessor extends AbstractSqlQueryProcessor{
	private static SqlReadQueryProcessor queryProcessor = new SqlReadQueryProcessor();
	
	private SqlReadQueryProcessor(){
		
	}
	
	public static SqlReadQueryProcessor getInstance(){
		return queryProcessor;
	}
	
	public <T> List<?> processReadQuery(String query , EntityFactory<T> factory) throws SQLException,Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			SqlResultProcessor resultProcessor = SqlResultProcessor.getInstance();
			SqlQueryExecutor executor = SqlQueryExecutor.getInstance();
			conn = getConnection();
			stmt = conn.createStatement();
			rs = executor.executeRead(stmt, query);
			List<?> entityList = resultProcessor.process(rs, factory);
			
			return entityList;
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				releaseConnection(conn);
			}
		}
	}

	@Override
	public int processDeleteQuery(String query) throws Exception {
		throw new Exception();
	}

	@Override
	public int processInsertQuery(String query, boolean processInBatch) throws Exception {
		throw new Exception();
	}

	@Override
	public int processUpdateQuery(String query) throws Exception {
		throw new Exception();
	}
	
}
