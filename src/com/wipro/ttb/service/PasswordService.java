package com.wipro.ttb.service;

import com.wipro.ttb.bean.PasswordBean;
import com.wipro.ttb.dao.PasswordDao;

public class PasswordService {

	public PasswordService() {
		
	}

	public String checkUser(PasswordBean passwordBean) {
		PasswordDao passwordDao = new PasswordDao();
	
		
		if(isNullOrEmpty(passwordBean.getLoginStatus()) && isNullOrEmpty(passwordBean.getPassword())) {
			if((passwordDao.checkForgotUser(passwordBean)) == 1){
				return "USER_AVAILABLE";
			}
		}
		return "NOT_AVAILABLE";
		
	}
	
	 private static boolean isNullOrEmpty(String str) {
	        if(str != null && !str.isEmpty())
	            return false;
	        return true;
	    }
}
