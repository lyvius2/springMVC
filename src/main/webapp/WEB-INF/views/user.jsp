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
	<h1>User Info</h1>
	
	<dl>
		<dt>번호</dt><dd>${user.no }</dd>
		<dt>이름</dt><dd>${user.name }</dd>
		<dt>전화번호</dt><dd>${user.phone }</dd>
		<dt>이메일</dt><dd>${user.email }</dd>
	</dl>
	
	<!-- 시큐어코딩 -->
	<dl>
		<dt>번호</dt><dd><c:out value="${user.no }"/></dd>
		<dt>이름</dt><dd><c:out value="${user.name }"/></dd>
		<dt>전화번호</dt><dd><c:out value="${user.phone }"/></dd>
		<dt>이메일</dt><dd><c:out value="${user.email }"/></dd>
	</dl>
	
	<p>
		<a href="users">List</a>
	</p>
</body>
</html>