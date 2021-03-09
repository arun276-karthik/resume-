<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%--@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"--%>
<%-- @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Employee</title>
</head>
<body>
	<form action="EmployeeController?action=insert" method="post">
		<%--input type="hidden" name="action" value="insert" /--%>
		<table style="background-color: yellow; margin-left: 20px; margin-right: 20px;">
			<hr>
			<a href="index.jsp"><button type="button">Home</button>
			<hr>
  
		<h3>Employee Detail</h3>
			<tr>
				<td>First Name</td>
				<td><input type="text" placeholder="Enter First Name"
					name="firstName" required></td>
				<td>Last Name</td>
				<td><input type="text" placeholder="Enter Second Name"
					name="lastName"></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text" placeholder="Enter Designation"
					name="designation"></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" placeholder="Enter Salary" name="salary"></td>
			</tr>
			<tr>
				<td>Email-Id</td>
				<td><input type="email" placeholder="Enter Email"
					name="emailId"></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><input type="date" placeholder="Enter BirthDate"
					name="dateOfBirth"></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input type="text" placeholder="Enter Phone Number"
					name="phoneNumber"></td>
			</tr>
		</table>
		<table style="background-color: yellow; margin-left: 20px; margin-right: 20px;">

			<h3>Current Address</h3>
			<br>
			<tr>
				<td>Street Address</td>
				<td><input type="text" placeholder="Enter Address"
					name="currentStreetAddress"></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" placeholder="Enter City" name="currentCity"></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" placeholder="Enter State" name="currentState"></td>
			</tr>
			<tr>
				<td>Postal Code</td>
				<td><input type="text" placeholder="Enter PostalCode"
					name="currentPostalCode"></td>
			</tr>
		</table>
		<table style="background-color: yellow; margin-left: 20px; margin-right: 20px;">

			<h3>Permanent Address</h3>
			<br>
			<tr>
				<td>Street Address</td>
				<td><input type="text" placeholder="Enter Address"
					name="streetAddress"></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" placeholder="Enter City" name="city"></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" placeholder="Enter State" name="state"></td>
			</tr>
			<tr>
				<td>Postal Code</td>
				<td><input type="text" placeholder="Enter PostalCode"
					name="postalCode"></td>
			</tr>
		</table>
		<center>
			<td><input type="submit" name="submit" value="Submit"></td>
		</center>
	</form>
	<p>
		<a href="employeeList.jsp"><button type="button">Employees-List</button></a>
	</p>
</body>
</html>