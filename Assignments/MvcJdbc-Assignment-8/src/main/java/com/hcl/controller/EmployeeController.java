package com.hcl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.dao.EmployeeDAO;
import com.hcl.model.Employee;

@WebServlet("/register")
public class EmployeeController extends HttpServlet {
  
    private EmployeeDAO employeeDAO;//HAS A

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        Employee employee = new Employee();//model object
        
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setContact(contact);
        employee.setAddress(address);
        request.setAttribute("action", "register");
        request.setAttribute("employee", employee);

        try {
            employeeDAO.registerEmployee(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Servlet path is: "+request.getServletPath());
        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
        //response.sendRedirect("success.jsp");
    }
}