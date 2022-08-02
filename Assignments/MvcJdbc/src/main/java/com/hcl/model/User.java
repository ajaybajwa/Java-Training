package com.hcl.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private String username;
	private String fullname;
	private String password;
	private String userType;
	public boolean validateUserNamePwd() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "root");
		PreparedStatement ps = con.prepareStatement("select username, name, password, usertype from users");
		ResultSet rs = ps.executeQuery();
		boolean status = false;
		while (rs.next()) {

			if (username.equals(rs.getString(1)) && password.equals(rs.getString(3))) {

				userType = rs.getString(4);
				fullname = rs.getString(2);
				status = true;
			}
		}
		
		return status;
	}
}
