package com.wipro.ttb.service;

import com.wipro.ttb.bean.LoginBean;
import com.wipro.ttb.dao.LoginDAO;

public class LoginService {

	public LoginService() {
		super();
	}

	public String queryIntoDB(LoginBean loginBean) {
		// Gets data from controller in form of Bean.
		// Queries DAO and gets result.
		// Returns object.
		String status;

		LoginDAO loginDAO = new LoginDAO();
		status = loginDAO.queryUser(loginBean);

		System.out.println(status);
		if (status.equals("USER_AVAILABLE")) {
			return "USER_AVAILABLE";

		} else if (status.equals("NOT_AVAILABLE")) {
			return "NOT_AVAILABLE";

		}
		return "EXCEPTION";
	}

}
