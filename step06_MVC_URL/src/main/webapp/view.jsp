<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body>
<h2>view</h2>
${requestScope.id} - ${requestScope.age}<br/>
${param.id} - ${param.age}
</body>
</html>