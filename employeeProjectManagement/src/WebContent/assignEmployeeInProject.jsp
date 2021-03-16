<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
    <form action="EmployeeController?action=projectAssign" method="post">
        <input type="hidden" name="employeeId" value="${employee.employeeId}"/>
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
	    	    	   <th>Assigning Project</th>
	               </tr>
	           	   <tr>
			           <c:forEach var="projectDetail" items="${projectList}">
			           <td>${projectDetail.projectId}</td>
    	          	   <td>${projectDetail.projectName}</td>
	               	   <td>${projectDetail.projectDueDate}</td>
			           <td>${projectDetail.projectManager}</td>
			           <c:choose>
			           <c:when test = "${fn:contains(employee.getProjects(), projectDetail)}">
			           <td><input type="checkbox" name="project" value="${projectDetail.projectId}" checked="checked"/></td>
                       </c:when>
                       <c:otherwise>
                       <td><input type="checkbox" name="project" value="${projectDetail.projectId}"/></td>
                       </c:otherwise>
                       </c:choose>
            	   </tr>
            	   </c:forEach>
            	   </table>
		       <br>
		       <td><input type="submit" name="submit" value="Submit"></td>
		      </div>
	    </center>
	</form>
</body>
</html>
</body>
</html>}