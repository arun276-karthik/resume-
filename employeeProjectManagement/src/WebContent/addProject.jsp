<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Project</title>
</head>
<body>
<hr>
    <a href="index.jsp"><button type="button">Home</button></a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="ProjectController?action=list"><button type="button">Project List</button></a>
	<hr>
	<center>
	<h1>Employee Management</h1>
	<form action="ProjectController?action=insert" method="post">
		<table style="background-color: yellow; margin-left: 20px; margin-right: 20px;">
		    <h3>Employee Detail</h3>
			<tr>
				<td>Project Name</td>
				<td><input type="text" placeholder="Hibernate"
					name="projectName" required></td>
				</tr>
				<tr>
				<td>Due Date</td>
				<td><input type="date" placeholder="Project Due Date"
					name="projectDueDate" required></td>
			</tr>
			<tr>
				<td>Project Manager</td>
				<td><input type="text" placeholder="Manager Name"
					name="projectManager"  pattern="[a-zA-Z. ]+" required></td>
			</tr>
				</table>
		<table style="background-color: yellow; margin-left: 20px; margin-right: 20px;">

			<h3>Permanent Address</h3>
			<br>
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
		<table style="background-color: yellow; margin-left: 20px; margin-right: 20px;">

			<h3>Current Address</h3>
			<br>
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
			<td><input type="submit" name="submit" value="Submit"></td>
		</center>
	</form>
	</center>
</body>
</html>