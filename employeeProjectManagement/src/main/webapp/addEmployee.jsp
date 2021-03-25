<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
<form:form method = "get" action = "/employeeList"><button class="button" >Employee List</button></form:form>
<hr>
<center>
<h1>Employee Management</h1>
<form:form action= "/insertEmployee" method="post" modelAttribute="employee">
<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">
<h3>Employee Detail</h3>
<tr>
<td>First Name</td>
<td><form:input placeholder="Enter First Name"
path="firstName" pattern="[a-zA-Z. ]+" required></td>
<td>Last Name</td>
<td><form:input placeholder="Enter Second Name"
path="lastName" pattern="[a-zA-Z. ]+" required></td>
</tr>
<tr>
<td>Designation</td>
<td><form:input placeholder="Enter Designation"
path="designation"  pattern="[a-zA-Z. ]+" required></td>
</tr>
<tr>
<td>Salary</td>
<td><form:input  placeholder="Enter Salary" path="salary"
pattern="[0-9]+" required></td>
</tr>
<tr>
<td>Email-Id</td>
<td><form:input placeholder="xyz@example.com"
path="emailId"  required></td>
</tr>
<tr>
<td>Date Of Birth</td>
<td><form:input placeholder="Enter BirthDate"
path="dateOfBirth"
pattern="^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$" required>
</td>
</tr>
<tr>
<td>Phone Number</td>
<td><form:input placeholder="Enter Phone Number"
path="phoneNumber" pattern="[0-9]{10}" required></td>
</tr>
</table>
<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">

<h3>Permanent Address</h3>
<tr>
<td>Street Address</td>
<td><form:input placeholder="DoorNumber,street,area"
path="employee.addresses[0].streetAddress" required></td>
</tr>
<tr>
<td>City</td>
<td><form:input placeholder="Chennai" path="employee.addresses[0].city" required></td>
</tr>
<tr>
<td>State</td>
<td><form:input placeholder="TamilNadu" path="employee.addresses[0].state" required></td>
</tr>
<tr>
<td>Postal Code</td>
<td><form:input  placeholder="Enter PostalCode"
path="employee.addresses[0].postalCode" pattern="[0-9]+" required></td>
</tr>
</table>
<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">

<h3>Current Address</h3>
<tr>
<td>Street Address</td>
<td><form:input placeholder="DoorNumber,street,area"
path="employee.addresses[1].streetAddress"  required></td>
</tr>
<tr>
<td>City</td>
<td><form:input placeholder="Chennai" path="employee.addresses[1].city" required></td>
</tr>
<tr>
<td>State</td>
<td><form:input placeholder="TamilNadu" path="employee.addresses[1].state" required></td>
</tr>
<tr>
<td>Postal Code</td>
<td><form:input placeholder="Enter PostalCode"
path="employee.addresses[1].postalCode" pattern="[0-9]+" required></td>
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
