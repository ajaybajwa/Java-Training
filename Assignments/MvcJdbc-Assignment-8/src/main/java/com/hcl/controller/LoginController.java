package com.hcl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.hcl.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginController extends HttpServlet {

	boolean status;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String uname = req.getParameter("un");
		String pwd = req.getParameter("pwd");
		//String userType="";
		Employee emp = new Employee();
		emp.setUsername(uname);
		emp.setPassword(pwd);
		req.setAttribute("abc", emp);
	
		try {
			status = emp.validateUserNamePwd();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}// model

		if (status) {
			
			if (emp.getUsername().equals("admin")) {
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
