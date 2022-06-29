<%@page import="com.spring.dto.Customer"%>
<%@page import="org.apache.catalina.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie cookie1 = new Cookie("id", "test");
	cookie1.setMaxAge(60 * 60 * 24);
	response.addCookie(cookie1);
	%>
	<h2>Index.jsp</h2>
	<hr>
	<h1>
		<a href="cookietest.do">cookietest.do</a><br>
	</h1>
	<hr>
	<h1>
		<a href="session.do">sessionView.do</a>
	</h1>
	<hr>
	<h1>
		<a href="session/loginForm.do">로그인</a>
		<c:if test="${sessionScope.pwd ne null}">
			<a href="session/logout.do">로그아웃</a>
		</c:if>
	</h1>
	<hr>
</body>
</html>