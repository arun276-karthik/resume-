<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
  background-color: #e48257;
    color: #393232;
}
</style>
<title>Add Project</title>
</head>
<body>
    <hr>
        <a href="index.jsp"><button type="button">Home</button></a>
	    &nbsp;&nbsp;&nbsp;&nbsp;
	    &nbsp;&nbsp;&nbsp;&nbsp;
	    <form method = "get" action = "/projectList"><button>Project List</button></form>
	<hr>
	    <center>
	    <h1>Project Management</h1>
	    <form:form action="/insertProject" method="post" modelAttribute="project">
		    <table style="background-color: #edffec; margin-left: 20px; margin-right: 20px;">
		        <h3>Project Detail</h3>
			    <tr>
			        <td>Project Name</td>
			        <td><form:input  placeholder="Hibernate"
				        path="projectName" /></td>
	    		</tr>
		    	<tr>
			        <td>Due Date</td>
			        <td><form:input type="date" placeholder="Project Due Date"
			    	    path="projectDueDate" /></td>
			    </tr>
			    <tr>
			        <td>Project Manager</td>
			        <td><form:input  placeholder="Manager Name"
				      path="projectManager"  pattern="[a-zA-Z. ]+" /></td>
	    		</tr>

		    </table>
		    <center>
		    <br>
			    <td><input type="submit"  value="Submit"></td>
		    </center>
	    </form:form>
	</center>
</body>
</html>