<%@ page import="com.hcl.model.User" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body>
	<input type="button" class="buttons" onClick="showHide(divAdd)"
		value="Add User">
	<input type="button" onClick="showHide(divDelete)" value="Delete user">
	<input type="button" onClick="showHide(divUpdate)" value="Update user">
	<input type="button" onClick="showHide(divView)" value="View user">
	
	<form action = "add_user" method ="post">
		<div id="divAdd" style = "display:none">
			User Name:<input type="text" name="username1"><br> 
			Name:<input type="text" name="name1"><br> 
			Password:<input type="text" name="password1"><br> 
			User Type:<input type="text" name="usertype1"> <br>
			<input type="submit" value="Add user"><br>
		</div>
		<br>
	</form>
	
	<form action= "delete_user" method = "post">
	<div id="divDelete" style = "display:none">
		User Name:<input type="text" name="username2"><br>
		<input type="submit" value="Delete user"><br>
	</div>
	</form>

<form action = "update_user" method = "post">
<div id="divUpdate" style = "display:none">
		User Name:<input type="text" name="oldusername3"><br> 
		New User Name:<input type="text" name="username3"><br> 
		Name:<input	type="text" name="name3"><br> 
		Password:<input type="text" name="password3"><br> 
		User Type:<input type="text" name="usertype3"><br>
		<input type="submit" value="Update user"><br>
	</div>
</form>
	
	</br>
	
	<form action = "view_user" method = "post">
	<div id="divView" style = "display:none">
	User Type:<input type="text" name="username4"><br>
		<input type="submit" value="Get user"><br>
	</div>
	</form>
	
</body>
<script>
	function showHide(x) {
		if (x.style.display == "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}

	}
</script>
</html>