<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
    <c:if test="{null != employee}">
	<form method="post" action="update">
	</c:if>
		<table border="1" cellpadding="5">
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
				<td><input type="text" name="lastName"
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
				<td><input type="date" value=${employee.dateOfBirth}
					name="dateOfBirth"></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input type="text" value=${employee.phoneNumber}
					name="phoneNumber"></td>
			</tr>
		</table>
		<c:forEach var="address" items="${employee.addresses}">
		<table 
			style="background-color: yellow; margin-left: 20px; margin-right: 20px;">

			<h3>Current Address</h3>
			<br>
			<tr>
				<td>Street Address</td>
				<td><input type="text" value=${address.streetAddress}
					name="streetAddress"></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" value=${address.city} name="city"></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" value=${address.state} name="state"></td>
			</tr>
			<tr>
				<td>Postal Code</td>
				<td><input type="text" value=${address.postalCode}
					name="postalCode"></td>
			</tr>
		</table>
		</c:forEach>
		<tr>
	<tr>
                    <td align="center">
                        <input type="submit" value="save" />
                    </td>
                </tr>
    </form>
</body>
</html>
</body>
</html>