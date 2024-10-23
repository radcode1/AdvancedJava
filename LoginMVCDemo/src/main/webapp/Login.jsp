<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> Login</h2><br>
	<form method="post" action="loginServlet">
	<h3>
		<% String error = (String)session.getAttribute("error");
			if(error != null){
				out.print(error);
				session.setAttribute("error", null);
			}
		%>
	</h3>
		UserName: <input type="text" name="username"><br><br>
		Password: <input type="password" name="password"><br><br>
		<input type="submit">
	</form>
</body>
</html>