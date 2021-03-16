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
<a href="EmployeeController?action=list"><button type="button" class="button">Employee List</button></a>
<hr>
<center>
<h1>Employee Management</h1>
<form action="EmployeeController?action=insert" method="post">
<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">
<h3>Employee Detail</h3>
<tr>
<td>First Name</td>
<td><input type="text" placeholder="Enter First Name"
name="firstName" pattern="[a-zA-Z. ]+" required></td>
<td>Last Name</td>
<td><input type="text" placeholder="Enter Second Name"
name="lastName" pattern="[a-zA-Z. ]+" required></td>
</tr>
<tr>
<td>Designation</td>
<td><input type="text" placeholder="Enter Designation"
name="designation"  pattern="[a-zA-Z. ]+" required></td>
</tr>
<tr>
<td>Salary</td>
<td><input type="text" placeholder="Enter Salary" name="salary"
pattern="[0-9]+" required></td>
</tr>
<tr>
<td>Email-Id</td>
<td><input type="email" placeholder="xyz@example.com"
name="emailId"  required></td>
</tr>
<tr>
<td>Date Of Birth</td>
<td><input type="date" placeholder="Enter BirthDate"
name="dateOfBirth"
pattern="^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$" required>
</td>
</tr>
<tr>
<td>Phone Number</td>
<td><input type="text" placeholder="Enter Phone Number"
name="phoneNumber" pattern="[0-9]{10}" required></td>
</tr>
</table>
<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">

<h3>Permanent Address</h3>
<tr>
<td>Street Address</td>
<td><input type="text" placeholder="DoorNumber,street,area"
name="currentStreetAddress" required></td>
</tr>
<tr>
<td>City</td>
<td><input type="text" placeholder="Chennai" name="currentCity" required></td>
</tr>
<tr>
<td>State</td>
<td><input type="text" placeholder="TamilNadu" name="currentState" required></td>
</tr>
<tr>
<td>Postal Code</td>
<td><input type="text" placeholder="Enter PostalCode"
name="currentPostalCode" pattern="[0-9]+" required></td>
</tr>
</table>
<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">

<h3>Current Address</h3>
<tr>
<td>Street Address</td>
<td><input type="text" placeholder="DoorNumber,street,area"
name="streetAddress"  required></td>
</tr>
<tr>
<td>City</td>
<td><input type="text" placeholder="Chennai" name="city" required></td>
</tr>
<tr>
<td>State</td>
<td><input type="text" placeholder="TamilNadu" name="state" required></td>
</tr>
<tr>
<td>Postal Code</td>
<td><input type="text" placeholder="Enter PostalCode"
name="postalCode" pattern="[0-9]+" required></td>
</tr>
</table>
<center>
<br>
<td><input type="submit" name="submit" value="Submit"></td>
</center>
</form>
</center>
</body>
</html>
