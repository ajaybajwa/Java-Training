package com.hcl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcl.model.Employee;

public class EmployeeDAO {
	public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" +
            "  (firstname, lastname, username, password, address, contact) VALUES " +
            " ( ?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");
      //try with resources-> it will close automatically. You dont have handle finally block
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            //preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getContact());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

	public int updateEmployee(Employee employee) throws ClassNotFoundException {
        String UPDATE_USER_SQL = "UPDATE USERS FIRSTNAME = ?, LASTNAME = ?, USERNAME = ?, "
        		+ "PASSWORD = ?, ADDRESS = ?, CONTACT = ? WHERE USERNAME = ?";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");
      //try with resources-> it will close automatically. You dont have handle finally block
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL)) {
            //preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getContact());
            preparedStatement.setInt(7, employee.getId());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
	
	public int deleteEmployee(Employee employee) throws ClassNotFoundException {
	    String DELETE_USER_SQL = "DELETE FROM EMPLOYEE WHERE ID = ?";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");
      //try with resources-> it will close automatically. You dont have handle finally block
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL)) {
            preparedStatement.setInt(1, employee.getId());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
		
	}
	
	public Employee searchEmployee(Employee employee) throws ClassNotFoundException, SQLException {
	    String SEARCH_USER_SQL = "SELECT * FROM EMPLOYEE WHERE ID = ?";
	    Employee emp = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
      //try with resources-> it will close automatically. You dont have handle finally block
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER_SQL)) {
            preparedStatement.setInt(1, employee.getId());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            emp = new Employee();
            while(rs.next()) {
            	emp.setId(rs.getInt(1));
            	emp.setFirstName(rs.getString(2));
            	emp.setLastName(rs.getString(3));
            	emp.setUsername(rs.getString(4));
            	emp.setPassword(rs.getString(5));
            	emp.setAddress(rs.getString(6));
            	emp.setContact(rs.getString(7));
            }
            
            
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        //System.out.println(emp.toString());
        return emp;
		
	}

	public List<Employee> retrieveEmployees( ) throws ClassNotFoundException, SQLException {
	    String RETRIEVE_EMPLOYEES_SQL = "SELECT * FROM EMPLOYEE";
	    List<Employee> empList = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
      //try with resources-> it will close automatically. You dont have handle finally block
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(RETRIEVE_EMPLOYEES_SQL)) {

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            empList = new ArrayList<Employee>();
            while(rs.next()) {
            	Employee emp = new Employee();
            	emp.setId(rs.getInt(1));
            	emp.setFirstName(rs.getString(2));
            	emp.setLastName(rs.getString(3));
            	emp.setUsername(rs.getString(4));
            	emp.setPassword(rs.getString(5));
            	emp.setAddress(rs.getString(6));
            	emp.setContact(rs.getString(7));
            	empList.add(emp);
            }
            
            
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        //System.out.println(empList.toString());
        return empList;
		
	}
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
