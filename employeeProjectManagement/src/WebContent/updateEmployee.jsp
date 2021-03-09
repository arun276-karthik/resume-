<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
	<form method="POST" action="employee">
	<input type="hidden" name="action" value="update" />
		<%
		int employeeId = request.getParameter("employeeId");
		int addressId = request.getParameter("addressId");
		if (!(null == (employeeId)) && !(null == (addressId))) {
			employee = employeeService.viewEmployeeDetails(employeeId);
		%>
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="employeeId" readonly="readonly"
					value="<%=employee.getEmployeeId()%>"></td>
			</tr>
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
		<table 
			style="background-color: yellow; margin-left: 20px; margin-right: 20px;">

			<h3>Current Address</h3>
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
		<table 
			style="background-color: yellow; margin-left: 20px; margin-right: 20px;">

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
		<tr>
			<%
			} else
			out.println("Employee ID Not Found");
			%>
		
	</form>
</body>
</html>
</body>
</html>