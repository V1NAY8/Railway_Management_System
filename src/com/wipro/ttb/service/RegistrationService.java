package com.wipro.ttb.service;

import com.wipro.ttb.bean.RegistrationBean;
import com.wipro.ttb.dao.RegistrationDAO;

public class RegistrationService {

	public RegistrationService() {
		super();
	}

	public String insertIntoDB(RegistrationBean regBean) {

		String status = "";

		RegistrationDAO dao = new RegistrationDAO();
		int count = dao.insertEmployee(regBean);

		if (count != 1) {
			status = "Success";

		} else
			status = "Fail";

		return status;
	}

}
