<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<style>
body {
  background-color: #e48257;
    color: #393232;
}
tr:hover {background-color:#f5f5f5;}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Project List</title>
</head>
<body>
	<input type="hidden" name="action" value="list" />
	<center>
		<h1>Project Management</h1>
		<h2>
			<a href="addProject.jsp">Add Project</a>
		</h2>
	</center>
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
				<th>Actions</th>
			</tr>
			<tr>
			<c:forEach var="project" items="${projectList}">
			<td>${project.projectId}</td>
				<td>${project.projectName}</td>
				<td>${project.projectDueDate}</td>
				<td>${project.projectManager}</td>
				<td>
				<form action = "ProjectController?action=edit" method = "post">
                <input type = "hidden" name = "projectId"  value = "${project.projectId}"/>
				<button type = "submit">EDIT</button>
				</form>
				<form action = "ProjectController?action=delete" method = "post">
				<input type = "hidden" name = "projectId" value = "${project.projectId}" />
				<button type = "submit" onclick="alert('Project detail would be deleted')">DELETE</button>
				</form>
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