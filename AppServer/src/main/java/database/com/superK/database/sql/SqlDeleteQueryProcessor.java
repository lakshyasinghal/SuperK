package com.superK.database.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
//import org.apache.log4j.Logger;
import com.superK.factory.entityFactory.EntityFactory;

public class SqlDeleteQueryProcessor extends AbstractSqlQueryProcessor {
	private static final SqlDeleteQueryProcessor queryProcessor = new SqlDeleteQueryProcessor();
	//private static final Logger LOGGER = Logger.getLogger(SqlDeleteQueryProcessor.class.getName());
	
	private SqlDeleteQueryProcessor(){
		
	}
	
	public static SqlDeleteQueryProcessor getInstance(){
		return queryProcessor;
	}
	
	public int processDeleteQuery(String query) throws Exception{
		//LOGGER.entering("SqlDeleteQueryProcessor", "processDeleteQuery");
		//LOGGER.finer("dbName:"+dbName);
		Connection conn = null;
		Statement stmt = null;
		int rowsAffected = -1;
		try{
			SqlQueryExecutor executor = SqlQueryExecutor.getInstance();
			conn = getConnection();
			stmt = conn.createStatement();
			rowsAffected = executor.executeUpdate(stmt, query);
			//LOGGER.exiting("SqlDeleteQueryProcessor", "processDeleteQuery");
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

	@Override
	public <T> List<?> processReadQuery(String query, EntityFactory<T> factory)
			throws Exception {
		throw new Exception();
	}

	@Override
	public int processInsertQuery(String query , boolean processInBatch) throws Exception {
		throw new Exception();
	}

	@Override
	public int processUpdateQuery(String query) throws Exception {
		throw new Exception();
	}
}
