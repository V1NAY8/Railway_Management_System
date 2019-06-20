/**
 * 
 */
package com.wipro.ttb.dao;

import java.sql.*;
import com.wipro.ttb.utils.*;
import com.wipro.ttb.bean.*;
/**
 * @author PP20085076
 *
 */
public class RegistrationDAO {

	/**
	 * 
	 */
	
	public int insertEmployee(RegistrationBean registrationBean){
		// TODO Auto-generated constructor stub
		int count = 0;
		try {
			Connection connection  = DBUtil.getDBConnection();
			String query = "INSERT INTO TTB01_TBL_TTB VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, registrationBean.getUserID());
			preparedStatement.setString(2,registrationBean.getFirstName());
			preparedStatement.setString(3,registrationBean.getLastName());
			preparedStatement.setDate(4,registrationBean.getDob());
			preparedStatement.setString(5,registrationBean.getGender());
			preparedStatement.setString(6,registrationBean.getEmailID());
			preparedStatement.setString(7,registrationBean.getPassword());
			preparedStatement.setString(8,registrationBean.getSq1());
			preparedStatement.setString(9,registrationBean.getSq2());
			preparedStatement.setString(10,registrationBean.getAddress());
			preparedStatement.setString(11,registrationBean.getCity());
			preparedStatement.setString(12,registrationBean.getDistrict());
			preparedStatement.setString(13,registrationBean.getCountry());
			preparedStatement.setInt(14,registrationBean.getPinCode());
			preparedStatement.setString(15,registrationBean.getState());
			preparedStatement.setString(16,registrationBean.getPhone());
			preparedStatement.setString(17,registrationBean.getLogin_status());
			preparedStatement.setString(18,registrationBean.getAccount_status());
			
			int rowsAffected  = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " Rows Added");
			
			
			
			
		}
		catch (Exception e) {
			System.out.println(e);
			count = count + 1;
		}
		return count;
	}

}
