<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> Registration Page</h2><br>
<h3>
<% String error = (String)session.getAttribute("error");
	
	if(error != null){
		out.print(error);
		session.setAttribute("error", null);
	}

%>
</h3>

<form method="post" action="register">
	First Name: <input type="text" name="firstname"><br><br>
	Last Name:  <input type="text" name="lastname"><br><br>
	User Name: <input type="text" name="username"><br><br>
	Password:  <input type="password" name="password"><br><br>
	<input type="submit">
</form>

</body>
</html>