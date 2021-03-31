<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<form:form method="post" action="/employeeUpdate" modelAttribute="employee">
			<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">
			<tr>
			<caption>
			    <h4>
			    Update Employee
			    </h4>
			</caption>
                <td>EmployeeId</td>
				<td><form:input readonly="true" path="employeeId"  value="${employee.employeeId}" required="required"/></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><form:input
					path="firstName" pattern="[a-zA-Z. ]+" value="${employee.firstName}" required="required"/></td>
				<td>Last Name</td>
				<td><form:input path="secondName" pattern="[a-zA-Z. ]+"
				 value="${employee.secondName}" required="required"/></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><form:input
					path="designation" pattern="[a-zA-Z. ]+" value="${employee.designation}" required="required"/></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><form:input path="salary" pattern="[0-9]+" value="${employee.salary}" required="required"/></td>
			</tr>
			<tr>
				<td>Email-Id</td>
				<td><form:input value="${employee.emailId}"
					path="emailId" required="required"/></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td ><form:input type="date" value="${employee.dateOfBirth}"
					path="dateOfBirth" required="required"/></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><form:input  pattern="[0-9]{10}" value="${employee.phoneNumber}"
					path="phoneNumber" required="required"/></td>
			</tr>
		</table>
        <table
			style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">
			<h3>Permanent Address</h3>
			<tr>
				<td>Street Address</td>
				<td><form:input path="addresses[0].streetAddress" value="${employee.addresses.get(0).streetAddress}" required="required"/></td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:input path="addresses[0].city" value="${employee.addresses.get(0).city}" required="required"/></td>
			</tr>
			<tr>
				<td>State</td>
				<td><form:input path="addresses[0].state" value="${employee.addresses.get(0).state}" required="required"/></td>
			</tr>
			<tr>
				<td>Postal Code</td>
				<td><form:input path="addresses[0].postalCode" pattern="[0-9]+" value="${employee.addresses.get(0).postalCode}" required="required"/></td>
			</tr>
			</table>
            <table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">

			            			<h3>Current Address</h3>
            			<tr>
            				<td>Street Address</td>
            				<td><form:input  path="addresses[1].streetAddress" value="${employee.addresses.get(1).streetAddress}" required="required"/></td>
            			</tr>
            			<tr>
            				<td>City</td>
            				<td><form:input path="addresses[1].city" value="${employee.addresses.get(1).city}" required="required"/></td>
            			</tr>
            			<tr>
            				<td>State</td>
            				<td><form:input path="addresses[1].state" value="${employee.addresses.get(1).state}" required="required"/></td>
            			</tr>
            			<tr>
            				<td>Postal Code</td>
            				<td><form:input path="addresses[1].postalCode" pattern="[0-9]+" value="${employee.addresses.get(1).postalCode}" required="required"/></td>
            			</tr>
		</table>

		<tr>
                    <td align="center">
                    <br>
                        <input type="submit" value="save"/>
                    </td>
    </tr>
    </form:form>
    </center>
</body>
</html>