<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("firstName") == null) {
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
	requestDispatcher.forward(request, response);
}
%>

<h1>Welcome <%= session.getAttribute("firstName") %></h1>

</body>
</html>