package com.wipro.ttb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.ttb.bean.PasswordBean;
import com.wipro.ttb.service.PasswordService;

/**
 * Servlet implementation class PasswordController
 */
@WebServlet("/PasswordController")
public class PasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Controller checks Username from forgotPassword.html and hence sends into DB and redirects to another page.
		
		String userRef = request.getParameter("userRef");
		// Create Cookie to Store User for this session.
		
		
		// Check DB
		PasswordBean passwordBean = new PasswordBean();
		passwordBean.setUserRef(userRef);
		passwordBean.setPassword(null);
		passwordBean.setLoginStatus(null);
		
		PasswordService passwordService = new PasswordService();
		if(passwordService.checkUser(passwordBean).equals("USER_AVAILABLE")) {
			
			
			// Logic for clicking Next in that page for security Question.
		}
		else {
			// Logic for Saying User not Available. Popup.
		}
		
	}

}
