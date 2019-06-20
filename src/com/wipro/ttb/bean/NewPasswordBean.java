package com.wipro.ttb.bean;

public class NewPasswordBean {

	public NewPasswordBean() {
		super();
	}

	private String sql;
	private String sq2;
	private String newpassword;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getSq2() {
		return sq2;
	}

	public void setSq2(String sq2) {
		this.sq2 = sq2;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

}
