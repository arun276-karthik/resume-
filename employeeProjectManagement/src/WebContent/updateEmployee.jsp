<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page import="java.util.List" %>
	<%@ page import="com.ideas2it.employeeProjectManagement.address.model.Address" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
<center>

	<form method="post" action="EmployeeController?action=update">
			<table style="background-color: yellow; margin-left: 20px; margin-right: 20px;">
			<tr>
			<caption>
			    <h4>
			    Update Employee
			    </h4>
			</caption>
				<td>Employee ID</td>
				<td><input name="employeeId" readonly="readonly" value="${employee.employeeId}"></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text"
					name="firstName" value=${employee.firstName} required></td>
				<td>Last Name</td>
				<td><input type="text" name="secondName"
				 value=${employee.secondName}></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text"
					name="designation" value=${employee.designation}></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text"  name="salary" value=${employee.salary}></td>
			</tr>
			<tr>
				<td>Email-Id</td>
				<td><input type="email" value=${employee.emailId}
					name="emailId"></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td ><input type="date" value=${employee.dateOfBirth}
					name="dateOfBirth"></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input type="text" value=${employee.phoneNumber}
					name="phoneNumber"></td>
			</tr>
		</table>
        <table
			style="background-color: yellow; margin-left: 20px; margin-right: 20px;">
			<h3>Permanent Address</h3>
			<br>
			<tr>
				<td>Street Address</td>
				<td><input type="text" name="streetAddress" value=${employee.addresses.get(0).streetAddress}></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city" value=${employee.addresses.get(0).city} ></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" name="state" value=${employee.addresses.get(0).state} ></td>
			</tr>
			<tr>
				<td>Postal Code</td>
				<td><input type="text" name="postalCode" value=${employee.addresses.get(0).postalCode}></td>
			</tr>
			            			<h3>Current Address</h3>
            			<br>
            			<tr>
            				<td>Street Address</td>
            				<td><input type="text" name="currentStreetAddress" value=${employee.addresses.get(1).streetAddress}></td>
            			</tr>
            			<tr>
            				<td>City</td>
            				<td><input type="text" name="currentCity" value=${employee.addresses.get(1).city} ></td>
            			</tr>
            			<tr>
            				<td>State</td>
            				<td><input type="text" name="currentState" value=${employee.addresses.get(1).state} ></td>
            			</tr>
            			<tr>
            				<td>Postal Code</td>
            				<td><input type="text" name="currentPostalCode" value=${employee.addresses.get(1).postalCode}></td>
            			</tr>
		</table>

		<tr>
	<tr>
                    <td align="center">
                        <input type="submit" value="save" />
                    </td>
    </tr>
    </form>
    </center>
</body>
</html>
</body>
</html>̥