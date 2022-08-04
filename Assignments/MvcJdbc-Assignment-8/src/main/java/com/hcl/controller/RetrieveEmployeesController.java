package com.hcl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.dao.EmployeeDAO;
import com.hcl.model.Employee;


@WebServlet("/retrieve")
public class RetrieveEmployeesController extends HttpServlet{

	private EmployeeDAO employeeDAO;//HAS A

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response)
    	    throws ServletException,IOException{
    	        response.setContentType("text/html");
    	        PrintWriter pw=response.getWriter();
    	        
    	        List<Employee> empList = new ArrayList<Employee>();
    	        
    	        request.setAttribute("action", "retrieve");
    	        

    	        try {
    	            empList = employeeDAO.retrieveEmployees();
    	            request.setAttribute("employeeList", empList);
    	            System.out.println("List of employees: "+empList.toString());
    	            
    	        } catch (Exception e) {
    	            // TODO Auto-generated catch block
    	            e.printStackTrace();
    	        }
    	        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
    			rd.forward(request, response);
    	        //response.sendRedirect("success.jsp");
    	    
    }
    
}