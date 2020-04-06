<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ELearning Student Home</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<%
String username =(String) session.getAttribute("stusername");
if(username==null)
{
	response.sendRedirect("/admin/");
}
%>
<div class="header1">
<h1 style="text-align: center"> Welcome<span style="color: yellow;"> <%=username.toUpperCase() %></span></h1> 

<ul>

<li ><a href="#">View Profile</a></li>

<li ><a href="/student/listcourse">View Cources</a></li>
<li ><a href="/student/mycourses">View My Cources</a></li>
<li ><a href="/student/logout">LogOut</a></li>
</ul>

</div>


<div align="center">
<table border="2">
<!--  JSTL Core Tag -->
<c:forEach items="${courseList}" var="course">

    <tr>
      <td>${course.courseid}</td>
       <td>${course.courseName}</td>
        <td>${course.fees}</td>
         <td>${course.duration}</td>
          <td>${course.startDate}</td>
           <td>${course.endDate}</td>
           <td> <a href="/student/applycourse?couresid=${course.courseid}" style="color: yellow;">Take This Course</a> </td>
    </tr>

</c:forEach>

</table>

</div>

</body>
</html>