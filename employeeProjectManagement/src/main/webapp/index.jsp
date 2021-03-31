<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  padding: 15px 25px;
  text-align: center;
  display: inline-block;
  font-size: 16px;
  border: 1px #3a6351;
}
</style>
<title>Employee Project Management</title>
</head>
<body>
	<center>
	<div>
		<h1>Employee Project Management</h1>
		<h2><button class="button">
            <a href="/getEmployee">Employee</a></button>
            &nbsp;&nbsp;&nbsp;
            <button type="button" class="button">
            <a href="/getProject">Project</a></button>
        </h2>
    </div>
	</center>
</body>
</html>