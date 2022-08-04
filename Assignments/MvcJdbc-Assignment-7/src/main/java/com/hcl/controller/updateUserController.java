package com.hcl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update_user")
public class updateUserController extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String oldUserName = req.getParameter("oldusername3");
		String username = req.getParameter("username3");
		String name = req.getParameter("name3");
		String password = req.getParameter("password3");
		String userType = req.getParameter("usertype3");
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "root");
		
			Statement st = con.createStatement();
			st.execute("UPDATE USERS SET USERNAME = '" +username+"', NAME = '"+name+"', PASSWORD = '"+password+"', USERTYPE = '"+userType+"' WHERE USERNAME = '"+oldUserName+"'");
			pw.println("User updated successfully");
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
