package com.wipro.ttb.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.ttb.bean.NewPasswordBean;
import com.wipro.ttb.service.NewPasswordService;

/**
 * Servlet implementation class forgotPasswordController
 */
@WebServlet("/forgotPasswordController")
public class forgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public forgotPasswordController() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in");
		String userName = request.getParameter("username");

		String sq1 = request.getParameter("pet");
		String sq2 = request.getParameter("food");
		String newpassword = request.getParameter("password");
		NewPasswordBean newpasswordBean = new NewPasswordBean();
		newpasswordBean.setUserName(userName);
		newpasswordBean.setSql(sq1);
		newpasswordBean.setSq2(sq2);
		newpasswordBean.setNewpassword(newpassword);
		NewPasswordService newpasswordService = new NewPasswordService();
		String redirect = newpasswordService.queryIntoDB(newpasswordBean);

		if (redirect.equals("USER_AVAILABLE")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
			dispatcher.forward(request, response);
		}
	}
}
