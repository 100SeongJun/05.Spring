<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page contentType="text/html;charset=utf-8"%>
<html>

<head>
<title>Home</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>

<body>

	<h1>Dept Data</h1>
	<button onclick="getAllData()">모든 데이터출력</button>
	<div id="test"></div>
	<hr>
	<div id=></div>
</body>
<script>
function getAllData(){
	var tests = document.getElementById("test");
	tests.innerHTML="";
	axios.get("http://localhost:8080/jdbc/api/searchAll").
		then(response => {
			let data = response.data;
			for (let v of data) {
				tests.innerHTML += "<div>dname:&nbsp" + v.dname + "&nbsp&nbspdeptno:&nbsp" + v.deptno + "&nbsp loc:&nbsp " + v.loc + "</div>";
			}
		})
}
	axios.get("http://localhost:8080/jdbc/api/search")
		.then(response => console.log(response.data))
	//(JSON) INSERT "/api/deptjson" => deptno: 90, dname : FRONTEND, loc : JEJU
	var dept = {
		"deptno": 2000,
		"dname": "FRONTEND",
		"loc": "JEJU"
	}

	axios.post("http://localhost:8080/jdbc/api/deptjson", dept)
	//< !--(FormEncoded) INSERT "/api/deptjson" => deptno: 100, dname : TEST, loc : TEST-- >
	var dept2 = "deptno=200&dname=TEST&loc=TEST"

	axios.post("http://localhost:8080/jdbc/api/deptform", dept2)


		//< !--get으로 값 받고  자바스크립트로 값 뿌리기-- >
			
</script>


</html>