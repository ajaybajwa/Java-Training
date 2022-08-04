package com.hcl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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


@WebServlet("/delete")
public class DeleteEmployeeController extends HttpServlet {

	private EmployeeDAO employeeDAO;//HAS A

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    	int id = Integer.parseInt(request.getParameter("id"));

        Employee employee = new Employee();//model object
        
        employee.setId(id);
        request.setAttribute("action", "delete");
        request.setAttribute("employee", employee);

        try {
            employeeDAO.deleteEmployee(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
        //response.sendRedirect("success.jsp");
    }
}