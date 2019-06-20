package com.wipro.ttb.service;

import com.wipro.ttb.bean.NewPasswordBean;
import com.wipro.ttb.dao.LoginDAO;
import com.wipro.ttb.dao.NewPasswordDAO;

public class NewPasswordService {

	public NewPasswordService() {
		super();
	}

	public String queryIntoDB(NewPasswordBean newpasswordBean) {
		// Gets data from controller in form of Bean.
		// Queries DAO and gets result.
		// Returns object.
		String status;

		NewPasswordDAO newPasswordDAO = new NewPasswordDAO();
		status = newPasswordDAO.queryUser1(newpasswordBean);

		System.out.println(status);
		if (status.equals("USER_AVAILABLE")) {
			return "USER_AVAILABLE";

		} else if (status.equals("NOT_AVAILABLE")) {
			return "NOT_AVAILABLE";

		}
		return "EXCEPTION";
	}

}
