<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<form name="insertEmployeeDetails" action="employeeController"
		method="post">
		<table name="inserttable"
			style="background-color: yellow; margin-left: 20px; margin-right: 20px;">
			<hr>
			<button class="customBtn" onclick="index.jsp">Home</button>
			<hr>
			<h3>Employee Detail</h3>
			<tr>
				<td>First Name</td>
				<td><input type="text" placeholder="Enter First Name"
					name="firstname"></td>
				<td>Last Name</td>
				<td><input type="text" placeholder="Enter Second Name"
					name="lastname"></td>
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
					name="email-id"></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><input type="date" placeholder="Enter BirthDate" name="dob"></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input type="text" placeholder="Enter Phone Number"
					name="phonenumber"></td>
			</tr>
		</table>
		<table name="inserttable"
			style="background-color: yellow; margin-left: 20px; margin-right: 20px;">

			<h3>Current Address</h3>
			<br>
			<tr>
				<td>Street Address</td>
				<td><input type="text" placeholder="Enter Address"
					name="streetaddress"></td>
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
					name="postalcode"></td>
			</tr>
		</table>
		<table name="inserttable"
			style="background-color: yellow; margin-left: 20px; margin-right: 20px;">

			<h3>Permanent Address</h3>
			<br>
			<tr>
				<td>Street Address</td>
				<td><input type="text" placeholder="Enter Address"
					name="streetaddress"></td>
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
					name="postalcode"></td>
			</tr>
		</table>
		<center>
			<td><input type="submit" name="submit" value="Submit"></td>
		</center>
	</form>
</body>
</html>