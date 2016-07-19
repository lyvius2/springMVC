<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>연락처</h1>
	<ul>
		<c:forEach var="contact" items="${contacts }">
			<li>${contact }</li>
		</c:forEach>
	</ul>
</body>
</html>