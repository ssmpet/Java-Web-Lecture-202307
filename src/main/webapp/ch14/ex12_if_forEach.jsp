<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL</title>
</head>
<body style="margin: 40px; margin-bottom:40px;">
	<h1>JSTL(JSP Standard Tag Library)</h1>
	<hr>
	
	<table border="1">
		<tr><th>아이디</th><th>이름</th><th>주소</th></tr>
	<c:forEach var="member" items="${members}" varStatus="loop">
		<tr>
			<td> <%-- id가 홀수면 글자색을 blue, 짝수면 red --%>
				<c:if test="${member.id % 2 == 1}">
					<span style="color: blue">${member.id} </span>
				</c:if>
				<c:if test="${member.id % 2 == 0 }">
					<span style="color: red">${member.id} </span>
				</c:if>
				
			</td>	
			<td> <%-- 첫번째줄 배경색을 yellow, 마지막줄은 cyan --%>
				<c:if test="${loop.first}">
					<span style="background: yellow">${member.name} </span>
				</c:if>
				<c:if test="${loop.last}">
					<span style="background: cyan">${member.name} </span>
				</c:if>
				<c:if test="${ not loop.first and not loop.last }">
					${member.name}
				</c:if>
			</td>
			<td> <%-- 한국이면 배경색을 orange, 미국이면 skyblue --%>
				<c:if test="${member.addr.country eq '한국'}">
					<span style="background: orange">${member.addr} </span>
				</c:if>
				<c:if test="${member.addr.country eq '미국'}">
					<span style="background: skyblue">${member.addr} </span>
				</c:if>
				<c:if test="${member.addr.country ne '한국' and member.addr.country ne '미국'}">
					${member.addr}
				</c:if>
			 </td>
		</tr>
	</c:forEach>	
	</table>

	<table border="1">
		<tr><th>아이디</th><th>이름</th><th>주소</th></tr>
		<c:forEach var="member" items="${members}" begin="1" end="3"  step="2">
			<tr>
				<td>${ member.id }</td>
				<td>${ member.name }</td>
				<td>${ member.addr }</td>
			</tr>
		</c:forEach>	
	</table>

</body>
</html>