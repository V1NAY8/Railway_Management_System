package com.wipro.ttb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.ttb.bean.RegistrationBean;
import com.wipro.ttb.service.RegistrationService;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
       

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String firstName = request.getParameter("firstName");
		  String lastName = request.getParameter("lastName");
		  String gender = request.getParameter("gender");
		  String dob = request.getParameter("dob");
		  String emailID = request.getParameter("email");
		  System.out.println(request.getParameter("mobile"));
		  String phone = request.getParameter("mobile");
		  String address = request.getParameter("address");	
		  String city = request.getParameter("city");
		  String district = request.getParameter("district");
		  String state = request.getParameter("state");
		  String country = request.getParameter("country");
		  int pinCode = Integer.parseInt(request.getParameter("pinCode"));
		  String password = request.getParameter("password");
		  String sq1 = request.getParameter("sq1");
		  String sq2 = request.getParameter("sq2");
		  
		  RegistrationBean regBean = new RegistrationBean();
		  regBean.setFirstName(firstName);
		  regBean.setLastName(lastName);
		  regBean.setGender(gender);
		  regBean.setDob(dob);
		  regBean.setEmailID(emailID);
		  regBean.setPhone(phone);
		  regBean.setAddress(address);
		  regBean.setCity(city);
		  regBean.setDistrict(district);
		  regBean.setState(state);
		  regBean.setCountry(country);
		  regBean.setPinCode(pinCode);
		  regBean.setPassword(password);
		  regBean.setSq1(sq1);
		  regBean.setSq2(sq2);
		  regBean.setUserID();
		  regBean.setLogin_status("inactive");
		  regBean.setAccount_status("inactive");
		  
		  // Call Registration service
		  RegistrationService registrationService = new RegistrationService();
		  String status = registrationService.insertIntoDB(regBean);
		  String name=firstName.substring(0,2).toUpperCase() + lastName.substring(0, 2).toUpperCase() + String.valueOf(phone).substring(6, 10);
		  request.setAttribute("name",name);
		  RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomePage.jsp");
		  dispatcher.forward(request,response);
		 // request.getRequestDispatcher("WelcomePage.jsp").forward(request, response);
		  System.out.println("Status is " + status);
		 
		  	
		
	}

}
