<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-color: #a0daa9;
}
tr:hover {background-color:#f5f5f5;}
</style>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<input type="hidden" name="action" value="list" />
	<center>
		<h1>Employee Management</h1>
		<h2>
			<a href="addEmployee.jsp">Add Employee</a>
		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List Of Employees</h2>
			</caption>
			<tr>
				<th>Employee Id</th>
				<th>First Name</th>
				<th>Second Name</th>
				<th>Designation</th>
				<th>Salary</th>
				<th>Email Id</th>
				<th>Date Of Birth</th>
				<th>Phone Number</th>
				<th>Permanent Address</th>
				<th>Permanent State</th>
				<th>Permanent City</th>
				<th>Postal Code</th>
				<th>Current Address</th>
				<th>Current State</th>
				<th>Current City</th>
				<th>Postal Code</th>
				<th>Actions</th>
				<th>Project Assigning</th>
			</tr>
			<tr>
			<c:forEach var="employee" items="${employeeList}">
			<td>${employee.employeeId}</td>
				<td>${employee.firstName}</td>
				<td>${employee.secondName}</td>
				<td>${employee.designation}</td>
				<td>${employee.salary}</td>
				<td>${employee.emailId}</td>
				<td>${employee.dateOfBirth}</td>
				<td>${employee.phoneNumber}</td>
				
                 <c:forEach var="address" items="${employee.addresses}">
				<td>${address.streetAddress}</td>
				<td>${address.city}</td>
				<td>${address.state}</td>
				<td>${address.postalCode}</td>
				</c:forEach>
				<td>
				<form action = "EmployeeController?action=edit" method = "post">
                <input type = "hidden" name = "employeeId"  value = "${employee.employeeId}"/>
				<button type = "submit">EDIT</button>
				</form>
				<form action = "EmployeeController?action=delete" method = "post">
				<input type = "hidden" name = "employeeId" value = "${employee.employeeId}" />
				<button type = "submit"  onclick="alert('Employee detail would be deleted')">DELETE</button>
				</form>
				</td>
				<td>
				<form action = "EmployeeController?action=projectList" method = "post">
                <input type = "hidden" name = "employeeId" value = "${employee.employeeId}" />
                <button type = "submit" >Assign Project</button>
                </form>
                <td>
				<form action = "EmployeeController?action=availableProjectList" method="post"">
                <input type = "hidden" name = "employeeId" value = "${employee.employeeId}" />
                <button type = "submit" >UnAssign Project</button>
                </form>
                </td>
                </td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</center>
</body>
</html>
</body>
</html>