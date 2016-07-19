<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>user</title>
</head>
<body>
	<h1>User List</h1>
	<ul>
		<!-- 
			UserController에서 모델을 사용해서 전달한 값을 표시하기
			model.addAttribute("userList", userList);
		 -->
		 <c:forEach var="user" items="${userList}">
		 	<li><a href="user?no=${user.no}">${user.name}</a>
		 </c:forEach>
	</ul>
	
	<p>
		<a href="register">Add</a>
	</p>
</body>
</html>