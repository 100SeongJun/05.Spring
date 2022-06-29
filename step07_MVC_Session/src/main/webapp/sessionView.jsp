<%@page import="org.apache.catalina.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>SessionTest1.jsp</h2>
	<hr>
	정보: ${sessionScope.Customer}
	<br> id : ${sessionScope.Customer.id}
	<br> age: ${sessionScope.Customer.age}
	<hr>
	<div>
	<a href="session/get.do">세션생성</a>
	</div>
	<div>
		<a href="session/remove.do">세션 삭제</a>
	</div>
	<!-- <div>
	<a href="session/removeAge.do">세션나이삭제</a>
	</div> -->
	<div><a href="index.do">Home</a></div>
</body>
</html>