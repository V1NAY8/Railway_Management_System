/**
 * 
 */
package com.wipro.ttb.service;

import com.wipro.ttb.bean.RegistrationBean;
import com.wipro.ttb.dao.RegistrationDAO;

/**
 * @author PP20085076
 *
 */
public class RegistrationService {

	/**
	 * 
	 */
	public RegistrationService() {
		// TODO Auto-generated constructor stub
	}

	public String insertIntoDB(RegistrationBean regBean) {
		// TODO Auto-generated method stub
		String status = "";
		
		RegistrationDAO dao = new RegistrationDAO();
		int count = dao.insertEmployee(regBean);
		
		 if(count != 1)
		 {
			   status = "Success";
			   
		 }
		   else
			   status = "Fail";
		
		
		return status;
	}

}