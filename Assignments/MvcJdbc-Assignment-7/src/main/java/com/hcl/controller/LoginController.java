package com.hcl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.hcl.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	boolean status;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String uname = req.getParameter("un");
		String pwd = req.getParameter("pwd");
		//String userType="";
		User u1 = new User();
		u1.setUsername(uname);
		u1.setPassword(pwd);
		req.setAttribute("abc", u1);
	
		try {
			status = u1.validateUserNamePwd();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}// model

		if (status) {
			
			if (u1.getUserType().equals("admin")) {
				RequestDispatcher rdAdmin = req.getRequestDispatcher("admin.jsp");
				rdAdmin.forward(req, res);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
				rd.forward(req, res);
			}
			
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("failure.jsp");
			rd.forward(req, res);
		}

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
