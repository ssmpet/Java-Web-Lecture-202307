<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	pageContext.setAttribute("pid", "페이지 아이디");
%>
<c:set var="cid" value="코어 아이디"></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL</title>
</head>
<body style="margin: 40px; margin-bottom:40px;">
	<h1>JSTL(JSP Standard Tag Library)</h1>
	<hr>
	<c:set var="cid2" value="코어 아이디2"></c:set>
	<table border="1">
		<tr><th>표현식</th><th>결과</tr>
		<tr><td>\${ pid }</td><td>${ pid }</td></tr>	
		<tr><td>\${ cid }</td><td>${ cid }</td></tr>	
		<tr><td>\${ cid2 }</td><td>${ cid2 }</td></tr>	
		<tr><td></td><td></td></tr>	
		<tr><td>\${ members[0].addr.city }</td><td>${ members[0].addr.city }</td></tr>	
		<tr><td></td><td></td></tr>
		<c:set var="member0" value="${members[0]}"></c:set>
		<tr><td>\${ member0.id }</td><td>${ member0.id }</td></tr>
		<tr><td>\${ member0.name }</td><td>${ member0.name }</td></tr>
		<tr><td>\${ member0.addr }</td><td>${ member0.addr }</td></tr>
	</table>
	<br><br>
	<table border="1">
		<tr><th>아이디</th><th>이름</th><th>주소</th></tr>
		<c:forEach var="member" items="${members}">
			<tr>
				<td>${ member.id }</td>
				<td>${ member.name }</td>
				<td>${ member.addr }</td>
			</tr>
		</c:forEach>	
	</table>
	
</body>
</html>