<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page import="java.util.List" %>
	<%@ page import="com.ideas2it.employeeProjectManagement.address.model.Address" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-color: #e48257;
    color: #393232;
}
.right {
  position: absolute;
  right: 0px;
  width: 150px;
}
</style>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
<center>
    <div class="right">
        <a href="index.jsp"><button type="button">Home</button></a>
        </div>
	<form method="post" action="EmployeeController?action=update">
			<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">
			<tr>
			<caption>
			    <h4>
			    Update Employee
			    </h4>
			</caption>
				<td>Employee ID</td>
				<td><input type="hidden" name="employeeId" readonly="readonly" value="${employee.employeeId}" ></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text"
					name="firstName" pattern="[a-zA-Z. ]+" value=${employee.firstName} required></td>
				<td>Last Name</td>
				<td><input type="text" name="secondName" pattern="[a-zA-Z. ]+"
				 value=${employee.secondName}></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text"
					name="designation" pattern="[a-zA-Z. ]+" value=${employee.designation}></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text"  name="salary" pattern="[0-9]+" value=${employee.salary}></td>
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
				<td><input type="text"  pattern="[0-9]{10}" value=${employee.phoneNumber}
					name="phoneNumber"></td>
			</tr>
		</table>
        <table
			style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">
			<h3>Permanent Address</h3>
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
				<td><input type="text" name="postalCode" pattern="[0-9]+" value=${employee.addresses.get(0).postalCode}></td>
			</tr>
			</table>
            <table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">

			            			<h3>Current Address</h3>
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
            				<td><input type="text" name="currentPostalCode" pattern="[0-9]+" value=${employee.addresses.get(1).postalCode}></td>
            			</tr>
		</table>

		<tr>
                    <td align="center">
                    <br>
                        <input type="submit" value="save"/>
                    </td>
    </tr>
    </form>
    </center>
</body>
</html>