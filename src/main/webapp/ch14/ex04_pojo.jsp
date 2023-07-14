<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EL</title>
</head>
<body style="margin: 40px; margin-bottom:40px;">
	<h1>POJO(Plain Old Java Object)</h1>
	<table border="1">
		<tr><th>표현식</th><th>결과</tr>
		<tr><td>\${ m1.id }</td><td>${ m1.id }</td></tr>	
		<tr><td>\${ m1.name }</td><td>${ m1.name }</td></tr>	
		<tr><td>\${ m1.addr }</td><td>${ m1.addr }</td></tr>	
		<tr><td></td><td></td></tr>	
		<tr><td>\${ m2.id }</td><td>${ m2.id }</td></tr>	
		<tr><td>\${ m2.name }</td><td>${ m2.name }</td></tr>	
		<tr><td>\${ m2.addr.city }</td><td>${ m2.addr.city }</td></tr>	
		<tr><td></td><td></td></tr>	
		<tr><td>\${ members[0].id }</td><td>${ members[0].id }</td></tr>	
		<tr><td>\${ members[0].name }</td><td>${ members[0].name }</td></tr>	
		<tr><td>\${ members[0].addr.city }</td><td>${ members[0].addr.city }</td></tr>	
		<tr><td></td><td></td></tr>	
		<tr><td>\${ members[1].id }</td><td>${ members[1].id }</td></tr>	
		<tr><td>\${ members[1].name }</td><td>${ members[1].name }</td></tr>	
		<tr><td>\${ members[1].addr.city }</td><td>${ members[1].addr.city }</td></tr>	
	</table>
</body>
</html>