<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
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
				<th>Actions(/th>      
			</tr>
			<tr>
			<c:forEach var="employee" items="${employeeList}">
		
			<td><c:out value = "${employee.employeeId}" /></td>
				<td><c:out value = "${employee.get("firstName")}" /></td>
				<td><c:out value = "${employee.get("secondName")}" /></td>
				<td><c:out value = "${employee.get("designation")}" /></td>
				<td><c:out value = "${employee.get("salary")}" /></td>
				<td><c:out value = "${employee.get("emailId")}" /></td>
				<td><c:out value = "${employee.get("dateOfBirth")}" /></td>
				<td><c:out value = "${employee.get("phoneNumber")}" /></td>
				
				<c:forEach var="address" items="${employee.get("addresses")}">
				<td><c:out value="${address.get("streetAddress")}" /></td>
				<td><c:out value="${address.get("city")}" /></td>
				<td><c:out value="${address.get("state")}" /></td>
				<td><c:out value="${address.get("postalCode")}" /></td>
				</c:forEach>
				<td><a href="edit?employeeId=<c:out value='${employee.employeeId}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?employeeId=<c:out value='${employee.emailId}' />">Delete</a>  
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