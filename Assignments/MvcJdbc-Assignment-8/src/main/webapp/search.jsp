<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Employee Search Form</h1>
  <form action="<%= request.getContextPath() %>/search" method="get">
   <table style="with: 80%">
   <tr>
     <td>Id</td>
     <td><input type="number" name="id" /></td>
    </tr>
   </table>
   <input type="submit" value="Search" />
  </form>
 </div>
</body>
</html>