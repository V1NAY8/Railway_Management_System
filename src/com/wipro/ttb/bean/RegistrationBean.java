/**
 * 
 */
package com.wipro.ttb.bean;

/**
 * @author PP20085076
 *
 */
public class RegistrationBean {
	public RegistrationBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String userID;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String emailID;
	private int phone;
	private String address;	
	private String city;
	private String district;
	private String state;
	private String country;
	private int pinCode;
	private String password;
	private String sq1;
	private String sq2;
	private String login_status;
	private String account_status;	
	

	public String getUserID() {
		return userID;
	}
	
	public void setUserID() {
		String userID = this.firstName.substring(0,1).toUpperCase() + this.lastName.substring(0, 1).toUpperCase() + String.valueOf(this.phone).substring(6, 9);
		System.out.println(userID);
		this.userID = userID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getGender() {
		return gender;
	}
	public String getDob() {
		return dob;
	}
	public String getEmailID() {
		return emailID;
	}
	public int getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getDistrict() {
		return district;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public int getPinCode() {
		return pinCode;
	}
	public String getPassword() {
		return password;
	}
	
	public String getSq1() {
		return sq1;
	}
	public String getSq2() {
		return sq2;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSq1(String sq1) {
		this.sq1 = sq1;
	}
	public void setSq2(String sq2) {
		this.sq2 = sq2;
	}

	public String getLogin_status() {
		return login_status;
	}

	public String getAccount_status() {
		return account_status;
	}

	public void setLogin_status(String login_status) {
		this.login_status = login_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
	

	
	
}
