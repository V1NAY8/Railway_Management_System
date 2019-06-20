
package com.wipro.ttb.bean;

public class PasswordBean {

	public PasswordBean() {
		super();
	}

	// Bean for Password Reset.
	// Login status checked Warning close all other sessions.
	String userRef;
	String password;
	String loginStatus;

	public String getUserRef() {
		return userRef;
	}

	public void setUserRef(String userRef) {
		this.userRef = userRef;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

}
