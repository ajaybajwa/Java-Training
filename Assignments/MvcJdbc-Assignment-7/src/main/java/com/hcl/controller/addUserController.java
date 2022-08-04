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


@WebServlet("/add_user")
public class addUserController extends HttpServlet{
	Connection con;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String username = req.getParameter("username1");
		String name = req.getParameter("name1");
		String password = req.getParameter("password1");
		String userType = req.getParameter("usertype1");
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "root");
		
			Statement st = con.createStatement();
			st.execute("INSERT INTO USERS (USERNAME, NAME, PASSWORD, USERTYPE) VALUES ('"+username+"', '"+name+"', '"+password+"', '"+userType+"')" );
			pw.println("User Added Successfully.");
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
