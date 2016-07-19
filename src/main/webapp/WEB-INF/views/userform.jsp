<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>user</title>
<style type="text/css">
	.errors {color:red; font-style: italic;}
</style>
</head>
<body>
	<h1>User Form</h1>
	
	<form:form action="register" method="post" commandName="user">
		<form:errors path="*" cssClass="errors"></form:errors><br/>
		
		이름 <br/>
		<form:input type="text" path="name" /><br/>
		<form:errors path="name" cssClass="errors"></form:errors><br/>
		
		전화번호 <br/>
		<form:input type="text" path="phone" /><br/>
		<form:errors path="phone" cssClass="errors"></form:errors><br/>
		
		이메일 <br/>
		<form:input type="text" path="email" /><br/>
		주소 <br/>
		<form:input type="text" path="addr" /><br/>
		<input type="submit" />
	</form:form>
</body>
</html>