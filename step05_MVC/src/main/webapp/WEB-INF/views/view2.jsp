<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>view2</h2>
	<br/><hr>
	getOne<br/>
	1. 요청 객체에 저장된 새로운 데이터 출력 : ${requestScope.id}<br/>
	2. 요청 객체에 저장된 새로운 데이터 출력 : ${requestScope.age}<br/>
	3. ${requestScope.id} - ${requestScope.age}
	<hr>
	<br/><hr>
	getTwo<br/>
	1. 요청 객체에 저장된 새로운 데이터 출력 : ${requestScope.name}<br/>
	2. 요청 객체에 저장된 새로운 데이터 출력 : ${requestScope.age}<br/>
	3. ${requestScope.name} - ${requestScope.age}<br/>
	4. 객체로 데이터 받아오기
		- ${requestScope.customer.name}<br/>
		- ${requestScope.customer.age}
	<hr>
</body>
</html>