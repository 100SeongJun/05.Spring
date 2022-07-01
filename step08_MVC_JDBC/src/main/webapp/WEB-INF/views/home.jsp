<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page session="false" %>
  <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <html>

    <head>
      <title>Home</title>
      <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    </head>

    <body>
      <button id="btn" onclick="alldept()">모든 데이터 출력</button>
      <div id="result"></div>
      <input placeholder="id를 입력하세요."></input>
      <script>
        function alldept() {
        document.getElementById('result').innerHTML = ""
          axios.get('http://localhost:8080/api/depts').then((response) => {
            console.log(response.data);
            return response.data
          }).then((dept) => {
            document.getElementById('result').innerHTML += "<ul>"
            dept.map((data) => {
              document.getElementById('result').innerHTML += "<li> deptno: " + data.deptno +" dname: "+ data.dname +" loc:"+ data.loc +"</li>"
              document.getElementById('result').innerHTML += "<div/>";
            });
            document.getElementById('result').innerHTML += "</ul>"
          })
        }
        
        
      </script>
    </body>

    </html>