<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>

<head>
<title>Home</title>
</head>

<body>
	<h1>Hello world!</h1>
	<script></script>
	<P>The time on the server is ${serverTime}.</P>
	<div>${requestScope.deptno}</div>
	------------------------------------
	<div>${sessionScope.depts}</div>
	------------------------------------
	<br> ${allDept}

</body>

</html>