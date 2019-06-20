package com.wipro.ttb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.wipro.ttb.bean.NewPasswordBean;
import com.wipro.ttb.utils.DBUtil;

public class NewPasswordDAO {

	public NewPasswordDAO() {
		super();
	}

	public final String queryUser1(NewPasswordBean newpasswordBean) {
		int flag = 0;
		int returned_rows;
		try {
			Connection con = DBUtil.getDBConnection();
			String query = "Select COUNT(*) AS CNT from TTB01_TBL_TTB Where USER_REF = ? and (SQ1 = ? and SQ2 = ?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, newpasswordBean.getUserName());
			preparedStatement.setString(2, newpasswordBean.getSql());
			preparedStatement.setString(3, newpasswordBean.getSq2());
			// String newpass=newpasswordBean.getNewpassword();
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				returned_rows = rs.getInt("CNT");
				if (returned_rows > 0) {
					String query1 = "UPDATE TTB01_TBL_TTB SET PASSWORD =newpasswordBean.getNewpassword() where USER_REF=newpasswordBean.getUserName()";
					return "USER_AVAILABLE";
				} else {
					return "NOT AVAILABLE";
				}

			}
		} catch (Exception e) {
			System.out.println("NewPassword DAO");
			System.out.println(e);
			System.out.println(e.getStackTrace());
			flag = flag + 1;
		}
		return "EXCEPTION";
	}
}
