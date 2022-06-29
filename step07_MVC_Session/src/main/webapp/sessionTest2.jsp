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
	<h2>SessionTest2.jsp</h2>
	<br> 데이터 삭제 완료
	<br> 정보: ${sessionScope.Customer}
	<br> id : ${sessionScope.Customer.id}
	<br> age: ${sessionScope.Customer.age}
	<form action="index.do">
		<br>
		<button>Home</button>
	</form>
</body>
</html>