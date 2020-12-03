
package com.superK.connectionPool;

import java.sql.Connection;
import com.superK.factory.dbConnectionFactory.SqlConnFactory;

public class ConnectionPoolManager {
	private static ConnectionPool connectionPool = null;
	
	static {
		connectionPool = new SqlConnectionPool("localhost","3306","SuperK","root","root",10,SqlConnFactory.instance());
	}
	
	public static Connection getConnection() throws Exception{
		return connectionPool.getSqlConnection();
	}
	
	public static void releaseConnection(Connection conn) throws Exception{
		connectionPool.releaseSqlConnection(conn); 
	}
}