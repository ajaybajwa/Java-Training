<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@ page import="com.hcl.model.Employee" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- request is an implicit jsp object
     out is an implicit object in jsp 
 -->
	<%
	Employee u = (Employee) request.getAttribute("employee");
	List<Employee> empList = (ArrayList<Employee>)request.getAttribute("employeeList");
	
	if(request.getAttribute("action").equals("register")){
		out.println("<h1 style=color:blue> " + u.getFirstName() + ". <br> You have successfuly registered.</h1>");
	}
	
	if (request.getAttribute("action").equals("update")){
		out.println("<h1 style=color:blue> " + u.getFirstName() + "'s details have been successfuly updated.</h1>");
	}
	
	if (request.getAttribute("action").equals("delete")){
		out.println("<h1 style=color:blue> User successfuly deleted.</h1>");
	}
	
	 if (request.getAttribute("action").equals("search")){
		out.println("<h1 style=color:blue> ID: " +u.getId()+"<br>First name: "+u.getFirstName()+
				"<br>Last Name: "+u.getLastName()+"<br>Username: "+u.getUsername()+
				"<br>Address: "+u.getAddress()+"<br>Contact : "+u.getContact()  +"</h1>");
	}
	 
	 if (request.getAttribute("action").equals("retrieve")){
			out.println("<table><tr>"+
			"<th>ID</th>"+
			"<th>First name</th>"+
			"<th>Last name</th>"+
			"<th>Username</th>"+
			"<th>Address</th>"+
			"<th>Contact</th>"+
			"</tr>");
			
			 //out.println(empList);
			for (int i = 0; i<empList.size();i++){
				Employee em = empList.get(i);
				out.println("<tr><td>"+em.getId()+"</td><td>"+em.getFirstName()+"</td><td>"+em.getLastName()+"</td><td>"+em.getUsername()+"</td><td>"+em.getAddress()+"</td><td>"+em.getContact()+"</td></tr>");
				
			}
			out.print("</table>");
			/* empList.forEach((e)->{ //this code gives error
			out.print("<table><tr>"+
			"<td>"+e.getId()+"</td>"+
			"<td>"+e.getFirstName()+"</td>"+
			"<td>"+e.getLastName()+"</td>"+
			"<td>"+e.getUsername()+"</td>"+
			"<td>"+e.getAddress()+"</td>"+
			"<td>"+e.getContact()+"</td>"+
			"</tr></table>");}); */ 
			
		}
	%>
</body>
</html>