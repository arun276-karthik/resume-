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
.right {
  position: absolute;
  right: 0px;
  width: 150px;
}
</style>
<meta charset="ISO-8859-1">
<title>Update Project</title>
</head>
<body>
<center>
<div class="right">
        <a href="index.jsp"><button type="button">Home</button></a>
        </div>
	<form method="post" action="/projectUpdate">
			<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">
			<tr>
			<caption>
			    <h2>
			    Update Project
			    </h2>
			</caption>
				<td>Project ID</td>
				<td><input name="projectId" readonly="readonly" value="${project.projectId}" ></td>
			</tr>
			<tr>
				<td>Project Name</td>
				<td><input type="text"
					name="projectName" value=${project.projectName} required></td>
				<td>Project Due Date</td>
				<td><input type="date" name="projectDueDate"
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
                    <br>
                        <input type="submit" value="save" />
                    </td>
    </tr>
    </form>
    </center>
</body>
</html>