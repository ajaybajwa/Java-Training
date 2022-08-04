package com.hcl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/view_user")
public class viewUserController extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String username = req.getParameter("username4");
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "root");
		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM USERS WHERE USERNAME = '"+username+"'");
			while(rs.next()) {
			pw.println("<h2>User Name: "+rs.getString(1)+""+"</h2>");
			pw.println("<h2>Full Name: "+rs.getString(2)+""+"</h2>");
			pw.println("<h2>Password: "+rs.getString(3)+""+"</h2>");
			pw.println("<h2>User Type: "+rs.getString(4)+""+"</h2>");
			}
		
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
