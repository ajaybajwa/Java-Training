package cm.hcl.assignement_six;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpMgmtSys {

	static Connection con;
	Scanner s = new Scanner(System.in);

	public void showOptions() throws SQLException {

		System.out.println("Enter Option: \n1. To insert new employees.\n2. To view all employees."
				+ "\n3. To update employee details.\n4. To delete an employee.\n5. To view employee by ID.");

		int selection = s.nextInt();

		if (selection == 1) {
			insert();
		}
		if (selection == 2) {
			viewAll();
		}
		if (selection == 3) {
			update();
		}
		if (selection == 4) {
			delete();
		}
		if (selection == 5) {
			view();
		}
		s.close();
	}

	public void insert() throws SQLException {
		System.out.println("How many employees you want to add?");
		int n = s.nextInt();

		Statement st = con.createStatement();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter Employee " + i + " Name and Gender");
			int a = st.executeUpdate(
					"INSERT INTO EMPLOYEES (NAME, GENDER) VALUES ('" + s.next() + "','" + s.next() + "')");
			System.out.println(a + " record inserted");
		}
	}

	public void viewAll() throws SQLException {
		CallableStatement cs = con.prepareCall("{call viewEmployees()}");
		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			System.out.println("" + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}
	}

	public void update() throws SQLException {
		CallableStatement cs2 = con.prepareCall("{call updateEmployee(?,?,?)}");
		System.out.println("\nEnter the ID of employee to be updated.");
		cs2.setInt(1, s.nextInt());
		System.out.println("Enter new name and gender.");
		cs2.setString(2, s.next());
		cs2.setString(3, s.next());
		cs2.execute();
		System.out.println("Employee Updated");
	}

	public void delete() throws SQLException {
		System.out.println("\nEnter ID of the employee  to be deleted.");
		PreparedStatement ps = con.prepareStatement("Delete from employees where id = " + s.nextInt());
		ps.execute();
		System.out.println("Employee Deleted");
	}

	public void view() throws SQLException {
		System.out.println("Enter ID of employee to view details.");
		PreparedStatement ps2 = con.prepareStatement("Select * from employees where id = " + s.nextInt());
		ResultSet rs = ps2.executeQuery();
		while (rs.next()) {
			System.out.println("" + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "root");

		// PreparedStatement ps = con.prepareStatement("CREATE TABLE EMPLOYEES (ID
		// INT(3) AUTO_INCREMENT, NAME VARCHAR(100), GENDER VARCHAR(10), PRIMARY
		// KEY(ID))");
		// ps.execute();

		EmpMgmtSys ems = new EmpMgmtSys();
		ems.showOptions();

	}
}
