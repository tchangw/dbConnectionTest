package test;

import java.sql.*;

/*
 * Java DB Connection to a SQLExpress
 * 
 */

public class DBConnection extends SQLException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String uName = "dev";
		String pWord = "password";
		String db    = "dbname";
		String host  = "192.1.14.15";
		String port  = "5921";
		String instance = "sqlexpress";
		String dbURL;
		String sql = "SELECT * FROM Phone";
		
		Connection _connect  = null;
		PreparedStatement _preparedStatement = null;
		ResultSet _resultSet = null;
		
		dbURL = "jdbc:sqlserver://"+host+"\\"+instance+":"+port+";databaseName="+db+";user="+uName+";password="+pWord;  
		
		try{
			_connect = DriverManager.getConnection(dbURL);
			_preparedStatement = _connect.prepareStatement(sql);
			_preparedStatement.setEscapeProcessing(true);
			_resultSet = _preparedStatement.executeQuery();
			
			while(_resultSet.next()){
				System.out.println(_resultSet.getString(2) + ", " + _resultSet.getString(3) + " (phone #)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{_resultSet.close();} catch(Exception e){ /* ignored */}
			try{_preparedStatement.close();} catch(Exception e){ /* ignored */}
			try{_connect.close();} catch(Exception e){ /* ignored */}
		}
	}
}
