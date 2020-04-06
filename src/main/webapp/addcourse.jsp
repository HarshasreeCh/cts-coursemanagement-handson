<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
       <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Course - ELearning</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>

<div class="header1">
<h1>ELearning - Add Course</h1>

</div>
<!-- Form  -->
<div class="forms-data">

<form:form action="/admin/addcourse1" method="post" modelAttribute="course">

<table>
<tr>
<td>Course Name :</td>
<td><form:input path="courseName" class="form-control"/>
</td>
</tr>
<tr>
<td>Course Fees :</td>
<td><form:input path="fees" class="form-control"/>
</td>
</tr>
<tr>
<td>Course StartDate :</td>
<td><form:input path="startDate" class="form-control"/>
</td>
</tr>
<tr>
<td>Course EndDate :</td>
<td><form:input path="endDate" class="form-control"/>
</td>
</tr>
<tr>
<td><input type="submit" value="AddCourse"/>
</td>
</tr>
</table>
</form:form>
</div>
<a href="/adminhome.jsp">Back</a>
<%
RequestDispatcher rd = request.getRequestDispatcher("adminhome.jsp");
rd.include(request, response);
%>
</body>
</html>