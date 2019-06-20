/**
 * 
 */
package com.wipro.ttb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author PP20085076
 *
 */
public class DBUtil {

	/**
	 * 
	 */
	public static Connection getDBConnection() {
		// Creating connection and returning it.
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@10.209.61.33:1521:orcl", "team5", "team5");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
	
	public int closeDBConnection(Connection connection) {
		// Check flag whether connection is closed or not
		// if flag = 0 then connection closed
		// if flag  = 1 connection not closed 
		// try again to close the connection.
		int flag = 0;
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = 1;
		}
		return flag;
	}
}
