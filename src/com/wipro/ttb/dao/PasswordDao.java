package com.wipro.ttb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.ttb.bean.PasswordBean;
import com.wipro.ttb.utils.DBUtil;

public class PasswordDao {


	public int checkForgotUser(PasswordBean passwordBean) {
		// Check if User Exists in Database.
		
		int user_exists = 0;
		
		try {
			Connection connection = DBUtil.getDBConnection();
			String queryString = "SELECT COUNT(*) as CNT WHERE USER_REF = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, passwordBean.getUserRef());
			
			ResultSet rSet = preparedStatement.executeQuery();
			
			while(rSet.next()) {
				if(rSet.getInt("CNT") == 1) {
					user_exists = user_exists + 1;
					
				}
			}
				
		} catch (Exception e) {
			System.out.println("Check forgot User Class");
			System.out.println(e);
		}
		return user_exists;
	}
	
	
	
}
