<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
background-color: #e48257;
}
.right {
position: absolute;
right: 0px;
width: 150px;
}
.button {
background-color: #edffec;
border-radius: 4px;
color: black;
padding: 5px 15px;
text-align: center;
display: inline-block;
font-size: 12px;
border: 10px yellow;
}
.button {
transition-duration: 0.4s;
}

.button:hover {
background-color: #383e56;
color: white;
}
</style>
<title>Add Employee</title>
</head>
<body>
<hr>

<a href="index.jsp"><button type="button">Home</button></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<form method = "get" action = "employeeList"><button class="button" >Employee List</button></form>
<hr>
<center>
<h1>Employee Management</h1>
<form:form action= "insertEmployee" method="POST" modelAttribute="employee" >
<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">
<h3>Employee Detail</h3>
<tr>
<td>First Name</td>
<td><form:input path="firstName" /></td>
<td>Last Name</td>
<td><form:input path="secondName" /></td>
</tr>
<tr>
<td>Designation</td>
<td><form:input path="designation" /></td>
</tr>
<tr>
<td>Salary</td>
<td><form:input  path="salary" /></td>
</tr>
<tr>
<td>Email-Id</td>
<td><form:input type="email" path="emailId"  /></td>
</tr>
<tr>
<td>Date Of Birth</td>
<td><form:input type="date" path="dateOfBirth" />
</td>
</tr>
<tr>
<td>Phone Number</td>
<td><form:input path="phoneNumber"  /></td>
</tr>
</table>
<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">
<tr>
<form:hidden path="addresses[0].addressId"/>
</tr>
<h3>Permanent Address</h3>
<tr>
<td>Street Address</td>
<td><form:input path="addresses[0].streetAddress" /></td>
</tr>
<tr>
<td>City</td>
<td><form:input path="addresses[0].city" /></td>
</tr>
<tr>
<td>State</td>
<td><form:input path="addresses[0].state" /></td>
</tr>
<tr>
<td>Postal Code</td>
<td><form:input path="addresses[0].postalCode" /></td>
</tr>
</table>
<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">
<tr>
<form:hidden path="addresses[1].addressId"/>
</tr>
<h3>Current Address</h3>
<tr>
<td>Street Address</td>
<td><form:input path="addresses[1].streetAddress"  /></td>
</tr>
<tr>
<td>City</td>
<td><form:input path="addresses[1].city" /></td>
</tr>
<tr>
<td>State</td>
<td><form:input path="addresses[1].state" /></td>
</tr>
<tr>
<td>Postal Code</td>
<td><form:input path="addresses[1].postalCode"/></td>
</tr>
</table>
<center>
<br>
<td><input type="submit" value="Submit"></td>
</center>
</form:form>
</center>
</body>
</html>
