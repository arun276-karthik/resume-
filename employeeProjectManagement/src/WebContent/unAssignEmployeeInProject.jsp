<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ideas2it.employeeProjectManagement.employee.model.Employee" %>
<%@ page import="com.ideas2it.employeeProjectManagement.project.model.Project" %>
<!DOCTYPE html>
<html>
<style>
body {
  background-color: #e48257;
    color: #393232;
}
tr:hover {
background-color:#f5f5f5;
}
.right {
  position: absolute;
  right: 0px;
  width: 150px;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Project List</title>
</head>
<body>
    <div class="right">
        <a href="index.jsp"><button type="button">Home</button></a>
        </div>
    <form action="EmployeeController?action=projectUnAssign" method="post">
    <input type="hidden" name="employeeId" value="${employeeId}"/>
	<center>
		<h1>Project Management</h1>
		<h2>
		<a href="addEmployee.jsp">Add Employee</a>
		</h2>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List Of Projects</h2>
			</caption>
			<tr>
				<th>Project Id</th>
				<th>Project Name</th>
				<th>Project Due Date</th>
				<th>Project Manager</th>
				<th>UnAssign Project</th>
			</tr>
			<tr>
			<c:forEach var="project" items="${projectList}">
			<td>${project.projectId}</td>
				<td>${project.projectName}</td>
				<td>${project.projectDueDate}</td>
				<td>${project.projectManager}</td>
				<td><input type="radio" name="projectId" value="${project.projectId}"/></td>
			</tr>
			</c:forEach>
		</table>
			<td><input type="submit" name="submit" value="Submit"></td>
	</div>
	</form>
</body>
</html>
</body>
</html>