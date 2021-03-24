<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
  background-color: #e48257;
  color: #393232;
}
div {
  border: 2px solid black;
  padding: 5px;
  width: 50%
}
.button {
  background-color: #f2edd7;
  border-radius: 4px;
  color: black;
  padding: 10px 20px;
  text-align: center;
  display: inline-block;
  font-size: 12px;
  border: 1px #3a6351;
}
</style>
<title>Employee Id Management</title>
</head>
<body>
	<center>
	<c:choose>
	<c:when test="${employeeId > 0}">
	<div>
		<h1>Successfully added Employee Details </h1>
		<h2>Your Employee Id is ${employeeId}</h2>
		<a href="index.jsp"><button type="button" class="button">OK</button></a>
    </div>
    </c:when>
    <c:when test="${projectId > 0}">
		<div>
    		<h1>Successfully added Project Details </h1>
    		<h2>Project Id for this project is ${projectId}</h2>
    		<a href="index.jsp"><button type="button" class="button">OK</button></a>
        </div>
    </c:when>
    </c:choose>
	</center>
</body>
</html>