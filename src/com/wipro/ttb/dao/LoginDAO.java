package com.wipro.ttb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.wipro.ttb.bean.LoginBean;
import com.wipro.ttb.utils.DBUtil;

public class LoginDAO {
	public LoginDAO() {
		super();
	}

	// Should Create HTTP Session in service.
	public String queryUser(LoginBean loginBean) {
		// Logging in User
		// Flag = 0 => User Exists in database.
		// Input a Login Bean and then query database.
		// returns string which tells status.
		int flag = 0;
		int returned_rows;
		try {
			Connection con = DBUtil.getDBConnection();
			String query = "Select COUNT(*) AS CNT from TTB01_TBL_TTB Where USER_REF = ? and PASSWORD = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, loginBean.getUserName());
			preparedStatement.setString(2, loginBean.getPassword());

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				returned_rows = rs.getInt("CNT");
				if (returned_rows > 0) {
					return "USER_AVAILABLE";
				} else {
					return "NOT AVAILABLE";
				}
			}

		} catch (Exception e) {
			System.out.println("Login DAO");
			System.out.println(e);
			System.out.println(e.getStackTrace());
			flag = flag + 1;
		}

		return "EXCEPTION";
	}

	// Should Terminate that individual Session.
	public void logout(LoginBean loginBean) {
		// Logging out user.
		// Update Flags in DB
	}

}
