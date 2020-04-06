<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ELearning - Admin Home</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<%
String username =(String) session.getAttribute("adminusername");
if(username==null)
	
{
	response.sendRedirect("/admin/");
}
%>

<div class="header1">
<h1 style="text-align: center"> Welcome<span style="color: yellow;"> <%=username.toUpperCase() %></span></h1> 

<ul>
<li ><a href="#">Faculty</a></li>
<li ><a href="student">Students</a></li>
<li ><a href="/admin/addCourse">Add Course</a></li>
<li ><a href="#">List Course</a></li>
<li ><a href="/admin/adminLogout">LogOut</a></li>
</ul>

</div>
${addmessage}
${coursemessage}

</body>
</html>