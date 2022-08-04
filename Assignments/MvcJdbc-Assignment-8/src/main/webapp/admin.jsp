<%@ page import="com.hcl.model.Employee" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body>
	<input type="button" class="buttons" onClick="goToUpdate()" value="Update Employee">
	<button><a href="delete.jsp">Delete Employee</a></button>
	<button class="buttons"><a href="search.jsp">Search Employee</a></button>
	<form action="<%=request.getContextPath()%>/retrieve" method="get">
		<input type="submit" value="Retrieve All Employees" />
	</form>
	</br>
</body>
<script>
	function goToUpdate() {
		window.location.href = "update.jsp";
	}
</script>
</html>