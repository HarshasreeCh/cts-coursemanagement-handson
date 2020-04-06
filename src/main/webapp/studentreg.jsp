<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student page</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<div class="header1">
<h1>ELearning - StudentRegistration</h1>
</div>
<!-- Form  -->
<div align="center">
<div class="forms-data">
<form:form action="reg" method="post" modelAttribute="studentreg" style="margin-top:50px;">

<table>
<tr>
<td> Name :</td>
<td>
<form:input path="name" class="form-control"/>
<br>
<form:errors path="name" cssClass="errors"></form:errors>
</td>
</tr>
<tr>
<td>Password :</td>
<td><form:password path="password" class="form-control"/>
<br>
<form:errors path="password" cssClass="errors"></form:errors>
</td>
</tr>
<tr>
<td>Email :</td>
<td>
<form:input path="email" class="form-control"/>
<br>
<form:errors path="email" cssClass="errors"></form:errors>
</td>
</tr>
<tr>
<td>mobile :</td>
<td><form:password path="mobile" class="form-control"/>
<br>
<form:errors path="mobile" cssClass="errors"></form:errors>
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Register" class="formsubmitbutton" />
</tr>
</table>
</form:form>
</div>
<a href="/">Home</a>
</div>
</body>
</html>