package supercoders.parking.model.dao.database;

import java.sql.*;

public class SqlDbContext implements DataContext {

	private static SqlDbContext instance = new SqlDbContext();
	
	@Override
	public Connection getConnection() throws SQLException{
		//NOTE you need to copy 'mssql-jdbc_auth-11.2.1.x86.dll' and/or 'mssql-jdbc_auth-11.2.1.x64.dll' to the JRE BIN folder
		//e.g. 'c:\Program Files\Java\jdk-17.0.5\bin\'
		//for integrated security (windows authentication) to work
		return DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Parking;integratedSecurity=true;authenticationScheme=nativeAuthentication;encrypt=false");
	}

	public static SqlDbContext getInstance() {
		return instance;
	}
}