package com.hcl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.dao.EmployeeDAO;
import com.hcl.model.Employee;


@WebServlet("/search")
public class SearchEmployeeController extends HttpServlet{

	private EmployeeDAO employeeDAO;//HAS A

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response)
    	    throws ServletException,IOException{
    	        response.setContentType("text/html");
    	        PrintWriter pw=response.getWriter();
    	        
    	        int id = Integer.parseInt(request.getParameter("id"));

    	        Employee employee = new Employee();//model object
    	        
    	        employee.setId(id);
    	        request.setAttribute("action", "search");
    	        

    	        try {
    	            employee = employeeDAO.searchEmployee(employee);
    	            request.setAttribute("employee", employee);
    	            System.out.println(employee.toString());
    	            
    	        } catch (Exception e) {
    	            // TODO Auto-generated catch block
    	            e.printStackTrace();
    	        }
    	        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
    			rd.forward(request, response);
    	        //response.sendRedirect("success.jsp");
    	    
    }
    
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * int id = Integer.parseInt(request.getParameter("id"));
	 * 
	 * Employee employee = new Employee();//model object
	 * 
	 * employee.setId(id); request.setAttribute("action", "search");
	 * request.setAttribute("employee", employee);
	 * 
	 * try { employeeDAO.searchEmployee(employee); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } RequestDispatcher rd =
	 * request.getRequestDispatcher("success.jsp"); rd.forward(request, response);
	 * //response.sendRedirect("success.jsp"); }
	 */
}