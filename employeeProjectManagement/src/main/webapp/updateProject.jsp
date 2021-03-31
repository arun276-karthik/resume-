<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<form:form method="post" action="/projectUpdate" modelAttribute="project">
			<table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">
			<tr>
			<caption>
			    <h2>
			    Update Project
			    </h2>
			</caption>
			<td>ProjectId</td>
				<td><form:input readonly="true" path="projectId"  value="${project.projectId}" /></td>
			</tr>
			<tr>
				<td>Project Name</td>
				<td><form:input path="projectName" value="${project.projectName}" required="required"/></td>
				<td>Project Due Date</td>
				<td><form:input type="date" path="projectDueDate"
				 value="${project.projectDueDate}" required="required"/></td>
			</tr>
			<tr>
				<td>Project Manager</td>
				<td><form:input
					path="projectManager" value="${project.projectManager}" required="required"/></td>
			</tr>
			</table>
     	<tr>
                    <td align="center">
                    <br>
                        <input type="submit" value="save" />
                    </td>
    </tr>
    </form:form>
    </center>
</body>
</html>