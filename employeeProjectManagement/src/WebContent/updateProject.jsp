<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-color: #e48257;
    color: #393232;
}
</style>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
<center>

	<form method="post" action="ProjectController?action=update">
			<table style="background-color: yellow; margin-left: 20px; margin-right: 20px;">
			<tr>
			<caption>
			    <h4>
			    Update Project
			    </h4>
			</caption>
				<td>Project ID</td>
				<td><input name="projectId" readonly="readonly" value="${project.projectId}"></td>
			</tr>
			<tr>
				<td>Project Name</td>
				<td><input type="text"
					name="projectName" value=${project.projectName} required></td>
				<td>Project Due Date</td>
				<td><input type="text" name="projectDueDate"
				 value=${project.projectDueDate}></td>
			</tr>
			<tr>
				<td>Project Manager</td>
				<td><input type="text"
					name="projectManager" value=${project.projectManager}></td>
			</tr>
			</table>
     	<tr>
                    <td align="center">
                        <input type="submit" value="save" />
                    </td>
    </tr>
    </form>
    </center>
</body>
</html>